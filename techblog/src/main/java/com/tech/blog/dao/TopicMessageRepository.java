package com.tech.blog.dao;

import com.tech.blog.topic.TopicMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicMessageRepository extends JpaRepository<TopicMessage, Integer> {
    /**
     * This interface is used to extract the data form the database
     */

    /**
     * This method is used to extract a posted message by a user from the database
     * @param idMessage is the topic of the id
     * @param idTopic is the topic of the id
     * @param idUser is the id of the user
     * @return the topic message data from the database, otherwise null
     */
    Optional<TopicMessage> findByIdMessageAndIdTopicAndIdUser(Integer idMessage, Integer idTopic, Integer idUser);


    /**
     * @param topicId the id of the topic
     * @return a list with all the messages from a specific topic
     */
    @Query(nativeQuery = true, value = "EXEC dbo.GetTopicMessages ?1")
    Optional<List<TopicMessage>> findByTopicId(Integer topicId);

}
