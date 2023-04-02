package com.tech.blog.dao;

import com.tech.blog.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * This interface is used to extract the data form the database
     */

    /***
     * This method is used to extract a user form the database by the email
     * @param email is the email of the user
     * @return the user data if it was found in the database, otherwise null
     */
    Optional<User> findByEmail(String email);

    /***
     * This method is used to extract a user form the database by the email and password. It is used mainly for the user log in functionality
     * @param email is the email of the user
     * @param password is the password of the user
     * @return the user data if it was found in the database, otherwise null
     */
    Optional<User> findByEmailAndPassword(String email, String password);
}
