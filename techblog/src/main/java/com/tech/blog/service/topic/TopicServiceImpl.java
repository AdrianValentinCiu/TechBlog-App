package com.tech.blog.service.topic;

import com.tech.blog.dao.TopicMessageRepository;
import com.tech.blog.dao.TopicMessagesRepositoryDisplay;
import com.tech.blog.dao.TopicRepository;
import com.tech.blog.dao.TopicRepositoryDisplay;
import com.tech.blog.topic.Topic;
import com.tech.blog.topic.TopicDisplay;
import com.tech.blog.topic.TopicMessage;
import com.tech.blog.topic.TopicMessageDisplay;
import org.springframework.stereotype.Service;

import java.util.List;
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
    private TopicMessagesRepositoryDisplay topicMessageDisplay;
    private TopicRepositoryDisplay topicRepositoryDisplay;

    public TopicServiceImpl(TopicRepository topicRepository, TopicMessageRepository topicMessageRepository, TopicMessagesRepositoryDisplay topicMessageDisplay, TopicRepositoryDisplay topicRepositoryDisplay) {
        this.topicRepository = topicRepository;
        this.topicMessageRepository = topicMessageRepository;
        this.topicMessageDisplay = topicMessageDisplay;
        this.topicRepositoryDisplay = topicRepositoryDisplay;
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


    /**
     * This method is used to retreive all the topics from the database in order to be displayed in the user interface
     * @return all the topics from the database
     */
    @Override
    public List<TopicDisplay> getTopics() {
        Optional<List<TopicDisplay>> topics =  topicRepositoryDisplay.findByTopicId();
        if(topics!=null)
            return topics.get();
        return null;
    }

    /**
     * This method is used to retreive all the messages sent to a specific topic
     * @param topicId the id of the topic
     * @return
     */
    @Override
    public List<TopicMessageDisplay> getTopicMessages(Integer topicId) {
        Optional<List<TopicMessageDisplay>> topicMessages = topicMessageDisplay.findMessagesByTopicId(topicId);
        if(topicMessages!=null){
            return topicMessages.get();
        }
        return null;
    }


}
