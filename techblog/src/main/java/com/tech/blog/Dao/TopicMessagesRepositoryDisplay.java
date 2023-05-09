package com.tech.blog.Dao;

import com.tech.blog.Topic.TopicMessageDisplay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TopicMessagesRepositoryDisplay extends JpaRepository<TopicMessageDisplay, Integer> {
    /**
    * This interface is used to extract the data form the database
    */

    /**
     * @param topicId the id of the topic
     * @return a list with all the messages from a specific topic
     */
    @Query(nativeQuery = true, value = "EXEC dbo.GetTopicMessages ?1")
    Optional<List<TopicMessageDisplay>> findMessagesByTopicId(Integer topicId);
}
