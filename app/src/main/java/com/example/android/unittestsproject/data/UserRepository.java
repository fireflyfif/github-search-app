package com.example.android.unittestsproject.data;

import com.example.android.unittestsproject.model.User;

import java.util.List;

import rx.Observable;

public interface UserRepository {

    Observable<List<User>> searchUsers(String searchTerm);
}
