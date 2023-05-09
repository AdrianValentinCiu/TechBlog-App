package com.tech.blog.Service.User;

import com.tech.blog.Dao.AdditionalUserDataRepository;
import com.tech.blog.Dao.UserRepository;
import com.tech.blog.Dao.UserRepositoryDisplay;
import com.tech.blog.User.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, AppNewsObservable {
    /**
     * This class is used to implement all the functionality a user can have regarding accessing the database.
     * Holds teh business of a User logic.
     * For deleting a user only an ADMIN will be able to use that functionality.
     * This clas also implements the Observable interface for the design pattern Observer
     * @param userRepository used to communicate with the database
     * @param additionalUserDataRepository used to communicate with the database
     */
    private final UserRepository userRepository;
    private final AdditionalUserDataRepository additionalUserDataRepository;
    private final UserRepositoryDisplay userRepositoryDisplay;

    public UserServiceImpl(UserRepository userRepository, AdditionalUserDataRepository additionalUserDataRepository, UserRepositoryDisplay userRepositoryDisplay) {
        this.userRepository = userRepository;
        this.additionalUserDataRepository = additionalUserDataRepository;
        this.userRepositoryDisplay = userRepositoryDisplay;
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
        User user = userRepository.findById(IdUser).orElse(null);
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
        User findUser = userRepository.findByEmail(user.getEmail()).orElse(null);
        if(findUser == null) {
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
    public UserDisplay getUserById(Integer IdUser){
        return  userRepositoryDisplay.findUserById (IdUser).orElse(null);
    }

    /**
     * @param email the email of the user we want to return from the database
     * @return the user details from teh database
     */
    @Override
    public User getUserByEmail(String email) {
        return  userRepository.findByEmail(email).orElse(null);
    }

    /**
     * This method is used to extract all the users from the database
     * @return the list with all the available
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * This method is user to delete a user form the database by an ADMIN
     * @param IdDelAdmin the id of the ADMIN who is going to delete a user
     * @param IdAdminUser the id of the user
     * @return true if the delete was successfully, otherwise false
     */
    @Override
    public boolean deleteUser(Integer IdDelAdmin, Integer IdAdminUser) {
        User delUser = userRepository.findById(IdDelAdmin).orElse(null);
        User adminUser = userRepository.findById(IdAdminUser).orElse(null);
        if(adminUser != null && delUser != null && adminUser.getRole().equals(Role.ADMIN) && delUser.getRole().equals(Role.USER)) {
            userRepository.deleteById(IdDelAdmin);
            return true;
        }
        return false;
    }

    /**
     * @param firstName
     * @param lastName
     * @param info
     * @return true if the data was updated successfully in the database
     */
    @Override
    public boolean updateUserData(Integer userId, String firstName, String lastName, String info) {
        AdditionalUserData additionalUserData = new AdditionalUserData(userId, firstName, lastName, info);
        additionalUserDataRepository.save(additionalUserData);
        return true;
    }

    /**
     * This class is used to notify all users about a new update in the app
     * @param newUpdate represents all the new updates in the app
     */
    @Override
    public void setNewUpdate(String title, String newUpdate) {
        for(AppNewsObserver notifyUserAppUpdate : userRepository.findAll())
        {
            notifyUserAppUpdate.notify(title, newUpdate);
        }
    }
}
