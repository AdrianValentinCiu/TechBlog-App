package com.tech.blog;

import com.tech.blog.dao.TopicMessageRepository;
import com.tech.blog.dao.TopicRepository;
import com.tech.blog.service.topic.TopicService;
import com.tech.blog.service.topic.TopicServiceImpl;
import com.tech.blog.topic.Topic;
import com.tech.blog.topic.TopicMessage;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BlogApplicationTestsTopicService {
    @Mock
    private TopicRepository topicRepository;
    @Mock
    private TopicMessageRepository topicMessageRepository;

    @Test
    void testCreateTopic(){
        TopicService topicService = new TopicServiceImpl(topicRepository, topicMessageRepository);
        Topic topic = new Topic("topicTitle", 1);
        assertTrue(topicService.createTopic("topicTitle", 1) == true);
        verify(topicRepository).save(topic);
    }

    @Test
    void testPostMsgOnTopic(){
        TopicService topicService = new TopicServiceImpl(topicRepository, topicMessageRepository);
        TopicMessage topicMessage = new TopicMessage("topicTitle", 1, 2);
        assertTrue(topicService.postMsgOnTopic( 1, "topicTitle", 2) == true);
        verify(topicMessageRepository).save(topicMessage);
    }

    @Test
    void testLikeMsgOnTopic(){
        TopicService topicService = new TopicServiceImpl(topicRepository, topicMessageRepository);
        TopicMessage topicMessage = mock(TopicMessage.class);
        when(topicMessage.getLikesMessage()).thenReturn(1);
        when(topicMessageRepository.findByIdMessageAndIdTopicAndIdUser(1, 2, 3)).thenReturn(Optional.of(topicMessage));
        assertTrue(topicService.likeMsgOnTopic(1, 2, 3) == true);
        verify(topicMessage).setLikesMessage(topicMessage.getLikesMessage());
        verify(topicMessageRepository).save(topicMessage);
        verify(topicMessageRepository).findByIdMessageAndIdTopicAndIdUser(1, 2, 3);
    }
}
