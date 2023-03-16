package com.tech.blog.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        if(user != null)
            return setUserState(user.get(), false);
        return false;
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
    public boolean deleteUser(Integer IdDelAdmin, Integer IdAdminUser) {
        User delUser = getUserById(IdDelAdmin);
        User adminUser = getUserById(IdAdminUser);
        if(adminUser != null && delUser != null && adminUser.getRole().equals(Role.ADMIN) && delUser.getRole().equals(Role.USER)) {
            userRepository.deleteById(IdDelAdmin);
            return true;
        }
        return false;
    }
}
