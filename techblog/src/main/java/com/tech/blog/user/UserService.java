package com.tech.blog.user;

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
}
