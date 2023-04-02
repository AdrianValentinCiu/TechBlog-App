package com.tech.blog.service.topic;

import com.tech.blog.dao.TopicMessageRepository;
import com.tech.blog.dao.TopicRepository;
import com.tech.blog.topic.Topic;
import com.tech.blog.topic.TopicMessage;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {
    /**
     * This class is used to implement all the functionality a topic
     * Holds teh business of a Topic and TopicMessage logic.
     *
     * @param topicRepository used to communicate with the database
     * @param topicMessageRepository used to communicate with the database
     */

    private TopicRepository topicRepository;
    private TopicMessageRepository topicMessageRepository;

    public TopicServiceImpl(TopicRepository topicRepository, TopicMessageRepository topicMessageRepository) {
        this.topicRepository = topicRepository;
        this.topicMessageRepository = topicMessageRepository;
    }

    /**
     * This method is used to create a new topic
     * @param topicTitle is the title of the new topic
     * @param userAdminId is the admin of the person who created the topic
     * @return true if the post was created successfully
     */
    @Override
    public boolean createTopic(String topicTitle, Integer userAdminId) {
        topicRepository.save(new Topic(topicTitle, userAdminId));
        return true;
    }

    /**
     * This method is used to post a message on a specific topic
     * @param topicId is the id of the topic
     * @param msg is the message posted
     * @param userId is the id of the user who posts a message on this topic
     * @return true if the message was posted successfully on this topic
     */
    @Override
    public boolean postMsgOnTopic(Integer topicId, String msg, Integer userId) {
        topicMessageRepository.save(new TopicMessage(msg, topicId, userId));
        return true;
    }

    /**
     * This method is used to like a message from a topic
     * @param idMessage
     * @param topicId
     * @param userId
     * @return
     */
    @Override
    public boolean likeMsgOnTopic(Integer idMessage, Integer topicId, Integer userId) {
        Optional<TopicMessage> findTopicMessage = topicMessageRepository.findByIdMessageAndIdTopicAndIdUser(idMessage, topicId, userId);
        if (findTopicMessage != null) {
            System.out.println("found");
            TopicMessage topicMessage = findTopicMessage.get();
            topicMessage.setLikesMessage(topicMessage.getLikesMessage() + 1);
            topicMessageRepository.save(topicMessage);
            return true;
        }
        return false;
    }
}
