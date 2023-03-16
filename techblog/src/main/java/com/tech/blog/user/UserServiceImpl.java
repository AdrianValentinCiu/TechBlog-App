package com.tech.blog.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    /**
     * This class is used to implement all the functionality a user can have regarding accessing the database.
     * Holds teh business of a User logic.
     * For deleting a user only an ADMIN will be able to use that functionality.
     * @param userRepository used to communicate with the database
     */
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean login(String email, String password) {
        User user = getUserByEmail(email);
        return setUserState(user, false);
    }

    @Override
    public boolean logout(Integer IdUser) {
        User user = getUserById(IdUser);
        System.out.println(user);
        return setUserState(user, true);
    }

    private boolean setUserState(User user, boolean state){
        if(user != null && user.getIsOnline() == state){
            user.setIsOnline(!state);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean register(User user) {
        User findUSer = getUserByEmail(user.getEmail());
        if(findUSer == null) {
            userRepository.save(user);
            return true;
        }
        return false;
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

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
