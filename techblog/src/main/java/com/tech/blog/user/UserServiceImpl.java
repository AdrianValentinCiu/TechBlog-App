package com.tech.blog.user;

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

    /**
     * Logs in a user
     * @param email
     * @param password
     * @return true if the user was logged in successfully or false if the user is already logged in
     */
    @Override
    public boolean login(String email, String password) {
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        if(user != null)
            return setUserState(user.get(), false);
        return false;
    }

    /**
     * Logs off a user
     * @param IdUser
     * @return true if the user was logged off successfully or false if the user is already logged off
     */
    @Override
    public boolean logout(Integer IdUser) {
        User user = getUserById(IdUser);
        System.out.println(user);
        return setUserState(user, true);
    }

    /**
     * This method is used to change the state of a user from being online or offline
     * @param user
     * @param state
     * @return true if the user was found in the database and changing the state was successfully or false otherwise
     */
    private boolean setUserState(User user, boolean state){
        if(user != null && user.getIsOnline() == state){
            user.setIsOnline(!state);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    /**
     * @param user data of the user we want to register
     * @return true if the register was successfully
     */
    @Override
    public boolean register(User user) {
        User findUSer = getUserByEmail(user.getEmail());
        if(findUSer == null) {
            userRepository.save(user);
            return true;
        }
        return false;
    }

    /**
     * @param IdUser the id of the user we want to return from the database
     * @return the user details from teh database
     */
    @Override
    public User getUserById(Integer IdUser){
        return  userRepository.findById(IdUser).orElse(null);
    }

    /**
     * @param email the email of the user we want to return from the database
     * @return he user details from teh database
     */
    @Override
    public User getUserByEmail(String email) {
        return  userRepository.findByEmail(email).orElse(null);
    }

    /**
     * This method is user to delete a user form the database by an ADMIN
     * @param IdDelAdmin the id of the ADMIN who is going to delete a user
     * @param IdAdminUser the id of the user
     * @return true if the delete was successfully, otherwise false
     */
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
