package com.example.android.unittestsproject.data;

import com.example.android.unittestsproject.data.remote.GithubUserRestService;
import com.example.android.unittestsproject.model.User;

import java.io.IOException;
import java.util.List;

import rx.Observable;

public class UserRepositoryImpl implements UserRepository {

    private GithubUserRestService mGithubService;

    public UserRepositoryImpl(GithubUserRestService githubUserRestService) {
        mGithubService = githubUserRestService;
    }

    @Override
    public Observable<List<User>> searchUsers(final String searchTerm) {
        return Observable.defer(() -> mGithubService.searchGithubUser(searchTerm)
                .concatMap(userList -> Observable.from(userList.getItems())
                .concatMap(user -> mGithubService.getUser(user.getLogin())).toList()))
                .retryWhen(observable -> observable.flatMap(o -> {
                    if (o instanceof IOException) {
                        return Observable.just(null);
                    }
                    return Observable.error(o);
                }));
    }
}
