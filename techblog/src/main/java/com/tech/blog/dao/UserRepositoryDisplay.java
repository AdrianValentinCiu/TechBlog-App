package com.tech.blog.dao;

import com.tech.blog.user.UserDisplay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepositoryDisplay extends JpaRepository<UserDisplay, Integer> {
    /**
     * This interface is used to extract the data form the database
     */


    /**
     * This mehtod is used to return a user with all the information
     * @return the user
     */
    @Query(nativeQuery = true, value = "EXEC dbo.GetUserInfo ?1")
    Optional<UserDisplay> findUserById(Integer usedId);
}
