package com.tech.blog.dao;

import com.tech.blog.topic.TopicMessage;
import com.tech.blog.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicMessageRepository extends JpaRepository<TopicMessage, Integer> {
    /**
     * This method is used to extract a posted message by a user from the database
     * @param idMessage is the topic of the id
     * @param idTopic is the topic of the id
     * @param idUser is the id of the user
     * @return the topic message data from the database, otherwise null
     */
    Optional<TopicMessage> findByIdMessageAndIdTopicAndIdUser(Integer idMessage, Integer idTopic, Integer idUser);
}
