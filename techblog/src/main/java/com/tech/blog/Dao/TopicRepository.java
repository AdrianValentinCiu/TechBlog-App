package com.tech.blog.Dao;

import com.tech.blog.Topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
    /**
     * This interface is used to extract the data form the database
     */
}
