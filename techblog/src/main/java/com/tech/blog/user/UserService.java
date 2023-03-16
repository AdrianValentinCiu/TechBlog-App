package com.tech.blog.user;

public interface UserService {
    void login(Integer IdUser);

    void logout(Integer IdUser);

    void register(User user);

    User getUserById(Integer IdUser);

    User getUserByEmail(String email);

    void deleteUser(Integer IdUser);
}
