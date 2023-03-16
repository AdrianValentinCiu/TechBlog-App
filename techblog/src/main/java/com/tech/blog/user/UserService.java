package com.tech.blog.user;

public interface UserService {
    boolean login(String Email, String password);

    boolean logout(Integer IdUser);

    boolean register(User user);

    User getUserById(Integer IdUser);

    User getUserByEmail(String email);

    void deleteUser(Integer IdUser);

    void saveUser(User user);

}
