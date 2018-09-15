package com.example.android.unittestsproject.data.remote;

import com.example.android.unittestsproject.model.User;
import com.example.android.unittestsproject.model.UserList;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface GithubUserRestService {

    @GET("/search/users?per_page=10")
    Observable<UserList> searchGithubUser(@Query("q") String searchWord);

    @GET("/users/{username}")
    Observable<User> getUser(@Path("username") String userName);

}
