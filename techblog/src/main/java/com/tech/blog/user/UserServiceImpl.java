package com.tech.blog.user;

public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void login(User user) {

    }

    @Override
    public void logout(User user) {

    }

    @Override
    public void register(User user) {
        userRepository.save(user);
    }
}
