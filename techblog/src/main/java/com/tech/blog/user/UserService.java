package com.tech.blog.user;

public interface UserService {
    public void login(User user);

    public void logout(User user);

    public void register(User user);
}
