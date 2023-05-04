package com.tech.blog.service.topic;

import com.tech.blog.topic.Topic;
import com.tech.blog.topic.TopicMessage;

import java.util.List;

public interface TopicService {
    /**
         * This interface is used to implement the functionality about the topic data
     */
    List<Topic> getTopics();

    List<TopicMessage> getTopicMessages(Integer topicId);

    boolean createTopic(String topicTitle, Integer userAdminId);

    boolean postMsgOnTopic(Integer topicId, String msg, Integer userId);

    boolean likeMsgOnTopic(Integer idMessage, Integer topicId, Integer userId);
}
