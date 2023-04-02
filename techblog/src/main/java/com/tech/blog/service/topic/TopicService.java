package com.tech.blog.service.topic;

public interface TopicService {
    /**
         * This interface is used to implement the functionality about the topic data
     */
    boolean createTopic(String topicTitle, Integer userAdminId);

    boolean postMsgOnTopic(Integer topicId, String msg, Integer userId);

    boolean likeMsgOnTopic(Integer idMessage, Integer topicId, Integer userId);
}
