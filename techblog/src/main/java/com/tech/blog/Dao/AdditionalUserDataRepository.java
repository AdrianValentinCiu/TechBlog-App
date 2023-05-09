package com.tech.blog.Dao;

import com.tech.blog.User.AdditionalUserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalUserDataRepository extends JpaRepository<AdditionalUserData, Integer> {
    /**
     * This interface is used to extract the data form the database
     */
}
