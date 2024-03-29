package com.tech.blog.Service.Topic;

import com.tech.blog.Topic.TopicDisplay;
import com.tech.blog.Topic.TopicMessageDisplay;

import java.util.List;

public interface TopicService {
    /**
         * This interface is used to implement the functionality about the topic data
     */
    List<TopicDisplay> getTopics();

    List<TopicMessageDisplay> getTopicMessages(Integer topicId);

    Integer createTopic(String topicTitle, Integer userAdminId);

    boolean postMsgOnTopic(Integer topicId, String msg, Integer userId);

    Integer likeMsgOnTopic(Integer idMessage, Integer topicId);
}
