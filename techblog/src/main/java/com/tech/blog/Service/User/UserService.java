package com.tech.blog.Service.User;

import com.tech.blog.User.User;
import com.tech.blog.User.UserDisplay;

import java.util.List;

public interface UserService {
    /***
     * This interface is used to implement the functionality about the user data
     */

    boolean login(String Email, String password);

    boolean logout(Integer IdUser);

    boolean register(User user);

    UserDisplay getUserById(Integer IdUser);

    User getUserByEmail(String email);

    List<User> getAllUsers();

    boolean deleteUser(Integer IdUserAdmin, Integer IdUser);

    boolean updateUserData(Integer userId, String firstName, String lastName, String info);
}
