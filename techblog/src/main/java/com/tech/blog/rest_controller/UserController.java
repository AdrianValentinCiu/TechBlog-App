package com.tech.blog.rest_controller;

import com.tech.blog.rest_request.UserDataRequest;
import com.tech.blog.rest_request.UserDeleteRequest;
import com.tech.blog.rest_request.UserIdRequest;
import com.tech.blog.rest_request.RegAuthRequest;
import com.tech.blog.user.Role;
import com.tech.blog.user.User;
import com.tech.blog.service.user.UserService;
import com.tech.blog.user.UserDisplay;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {
    /**
     * This class is used to implement the REST controller, using the endpoints: GET, POST, PUT, DELETE
     * @param userService is used to use the functionality implemented
     */

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * This method is used to register a new user
     * @param request decoded data from JASON format
     * @return a boolean representing the state of the user: already registered (false) or new user (true)
     */
    @PostMapping("/auth/register")
    public ResponseEntity<Boolean> register(@RequestBody RegAuthRequest request){
        User user = new User(false, request.getEmail(), request.getPassword(), Role.USER);
        return ResponseEntity.ok(userService.register(user));
    }

    /**
     * This method is used to log in a user if it is not already logged in
     * @param request decoded data from JASON format
     * @return the data about the user
     */
    @PutMapping("/auth/login")
    public User login(@RequestBody RegAuthRequest request){
        if(userService.login(request.getEmail(), request.getPassword()) == true)
            return userService.getUserByEmail(request.getEmail());
        else
            return null;
    }

    /**
     * This method is used to log off a user if it is not already logged off
     * @param request decoded data from JASON format
     * @return a boolean representing the state of the user: logged in (false) or logged off (true)
     */
    @PutMapping("/auth/logout")
    public ResponseEntity<Boolean> logout(@RequestBody UserIdRequest request){
        return ResponseEntity.ok(userService.logout(request.getId()));
    }

    /**
     * This method is used by an admin in order to delete another user. An admin cannot delete another admin
     * @param request decoded data from JASON format
     * @return a boolean representing the state of the user: user deleted successfully (true) of user not found in the database (false)
     */
    @DeleteMapping("/user/delete_user")
    public ResponseEntity<Boolean> removeUser(@RequestBody UserDeleteRequest request){
        return ResponseEntity.ok(userService.deleteUser(request.getId(), request.getIdAdminUser()));
    }

    /**
     * This method is used to update the information about a specific user
     * @param request decoded data from JASON format
     * @return a boolean representing the state of the update
     */
    @PutMapping("/user/user_data")
    public ResponseEntity<Boolean> updateUserData(@RequestBody UserDataRequest request){
        return ResponseEntity.ok(userService.updateUserData(request.getUserId(), request.getFirstName(), request.getLastName(), request.getInfo()));
    }

    /**
     * This method is used to get the information about a specific user
     * @param user_id is the id of the user we want to retreive the data
     * @return JASON format of all the information about the specified user
     */
    @GetMapping("/user/{user_id}")
    @ResponseBody
    public UserDisplay dataUser(@PathVariable Integer user_id){
        return userService.getUserById(user_id);
    }

    /**
     * This method is used to extract all the users from the database
     * @return the list with all the users from the database
     */
    @GetMapping("/user/users")
    @ResponseBody
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


}
