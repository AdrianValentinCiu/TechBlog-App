package com.tech.blog.service;

import org.springframework.stereotype.Repository;


public interface subjectService {
    /**
     * implement the functionality about the topic's subjects
     */

    void createNewTopic(String topicTitle);

    void postOnTopic(Integer topicId, String message);

    void updateOnTopic(Integer topicId, String message);
}
