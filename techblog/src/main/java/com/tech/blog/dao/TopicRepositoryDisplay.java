package com.tech.blog.dao;

import com.tech.blog.topic.TopicDisplay;
import com.tech.blog.topic.TopicMessageDisplay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TopicRepositoryDisplay extends JpaRepository<TopicDisplay, Integer> {
    /**
     * This interface is used to extract the data form the database
     */

    /**
     * This method is used to return all topics from the database
     * @return a list with all topics
     */
    @Query(nativeQuery = true, value = "EXEC dbo.GetAllTopics")
    Optional<List<TopicDisplay>> findByTopicId();
}
