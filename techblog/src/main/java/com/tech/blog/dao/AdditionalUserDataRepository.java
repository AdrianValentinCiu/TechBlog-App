package com.tech.blog.dao;

import com.tech.blog.user.AdditionalUserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalUserDataRepository extends JpaRepository<AdditionalUserData, Integer> {
    /**
     * This interface is used to extract the data form the database
     */
}
