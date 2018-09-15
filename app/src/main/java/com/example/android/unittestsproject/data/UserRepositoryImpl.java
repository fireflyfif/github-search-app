package com.example.android.unittestsproject.data;

import com.example.android.unittestsproject.data.remote.GithubUserRestService;

public class UserRepositoryImpl implements UserRepository {

    private GithubUserRestService mGithubService;

    public UserRepositoryImpl(GithubUserRestService githubUserRestService) {
        mGithubService = githubUserRestService;
    }


}
