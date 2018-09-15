package com.example.android.unittestsproject.data;

import com.example.android.unittestsproject.data.remote.GithubUserRestService;
import com.example.android.unittestsproject.model.User;
import com.example.android.unittestsproject.model.UserList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Junit test for testing the network call, but without having the need to access the API
 * tutorial: https://riggaroo.co.za/introduction-android-testing-part3/
 */
public class UserRepositoryImplTest {

    private static final String USER_LOGIN_RIGGAROO = "riggaroo";
    private static final String USER_LOGIN_2_REBECCA = "rebecca";

    private UserRepository mUserRepository;

    @Mock
    GithubUserRestService githubUserRestService;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mUserRepository = new UserRepositoryImpl(githubUserRestService);
    }

    @Test
    public void searchUsers_200Response_CorrectApiCalls() {
        when(githubUserRestService.searchGithubUser(anyString()))
                .thenReturn(Observable.just(githubUserList()));

    }

    private UserList githubUserList() {
        User user = new User();
        user.setLogin(USER_LOGIN_RIGGAROO);

        User user2 = new User();
        user2.setLogin(USER_LOGIN_2_REBECCA);

        List<User> githubUsers = new ArrayList<>();
        githubUsers.add(user);
        githubUsers.add(user2);

        UserList userList = new UserList();
        userList.setItems(githubUsers);

        return userList;
    }

    private User user1FullDetails() {
        User user = new User();
        user.setLogin(USER_LOGIN_RIGGAROO);
        //user.setName("Rigs Franks");
        user.setAvatarUrl("avatar_url");
        //user.setBio("Bio1");

        return user;
    }

    private User user2FullDetails() {
        User user = new User();
        user.setLogin(USER_LOGIN_2_REBECCA);
        //user.setName("Rebeccs Franks");
        user.setAvatarUrl("avatar_url2");
        //user.setBio("Bio2");

        return user;
    }
}