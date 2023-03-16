package com.tech.blog.user;

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void login(Integer IdUser) {
        User user = getUserById(IdUser);
        user.setIsOnline(true);
        userRepository.save(user);
    }

    @Override
    public void logout(Integer IdUser) {
        User user = getUserById(IdUser);
        user.setIsOnline(false);
        userRepository.save(user);
    }

    @Override
    public void register(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(Integer IdUser){
        return  userRepository.findById(IdUser).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return  userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public void deleteUser(Integer IdUser) {
        userRepository.deleteById(IdUser);
    }
}
