package com.tech.blog.service;

import com.tech.blog.user.User;

public interface UserService {
    /***
     * This interface is used to implement the functionality about the user data
     */

    boolean login(String Email, String password);

    boolean logout(Integer IdUser);

    boolean register(User user);

    User getUserById(Integer IdUser);

    User getUserByEmail(String email);

    boolean deleteUser(Integer IdUserAdmin, Integer IdUser);

    boolean updateUserData(Integer userId, String firstName, String lastName, String info);
}
