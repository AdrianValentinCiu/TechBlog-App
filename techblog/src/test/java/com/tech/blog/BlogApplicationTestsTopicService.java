package com.tech.blog;

import com.tech.blog.Dao.TopicMessageRepository;
import com.tech.blog.Dao.TopicMessagesRepositoryDisplay;
import com.tech.blog.Dao.TopicRepository;
import com.tech.blog.Dao.TopicRepositoryDisplay;
import com.tech.blog.Service.Topic.TopicService;
import com.tech.blog.Service.Topic.TopicServiceImpl;
import com.tech.blog.Topic.Topic;
import com.tech.blog.Topic.TopicDisplay;
import com.tech.blog.Topic.TopicMessage;
import com.tech.blog.Topic.TopicMessageDisplay;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BlogApplicationTestsTopicService {
    @Mock
    private TopicRepository topicRepository;

    @Mock
    private TopicMessageRepository topicMessageRepository;

    @Mock
    private TopicMessagesRepositoryDisplay topicMessageDisplay;

    @Mock
    private TopicRepositoryDisplay topicRepositoryDisplay;

    @Test
    void testCreateTopic() {
        TopicService topicService = new TopicServiceImpl(topicRepository, topicMessageRepository, topicMessageDisplay, topicRepositoryDisplay);

        Topic topic = mock(Topic.class);
        when(topic.getIdTopic()).thenReturn(10);
        when(topicRepository.save(topic)).thenReturn(topic);
        Integer topicId = topicService.createTopic("topicTitle", 1);

        assertEquals(10, topicId);
        verify(topicRepository).save(topic);
    }

    @Test
    void testPostMsgOnTopic(){
        TopicService topicService = new TopicServiceImpl(topicRepository, topicMessageRepository, topicMessageDisplay, topicRepositoryDisplay);
        TopicMessage topicMessage = new TopicMessage("topicTitle", 1, 2);
        assertTrue(topicService.postMsgOnTopic( 1, "topicTitle", 2) == true);
        verify(topicMessageRepository).save(topicMessage);
    }

    @Test
    void testLikeMsgOnTopic(){
        TopicService topicService = new TopicServiceImpl(topicRepository, topicMessageRepository, topicMessageDisplay, topicRepositoryDisplay);
        TopicMessage topicMessage = mock(TopicMessage.class);
        when(topicMessage.getLikesMessage()).thenReturn(1);
        when(topicMessageRepository.save(topicMessage)).thenReturn(topicMessage);
        when(topicMessageRepository.findByIdMessageAndIdTopic(1, 2)).thenReturn(Optional.of(topicMessage));
        assertTrue(topicService.likeMsgOnTopic(1, 2) == 1);
        verify(topicMessage, times(2)).getLikesMessage();
        verify(topicMessage, times(2)).setLikesMessage(topicMessage.getLikesMessage());
        verify(topicMessageRepository).save(topicMessage);
        verify(topicMessageRepository).findByIdMessageAndIdTopic(1, 2);
    }

    @Test
    void testGetTopics(){
        TopicService topicService = new TopicServiceImpl(topicRepository, topicMessageRepository, topicMessageDisplay, topicRepositoryDisplay);
        TopicDisplay topic1 = new TopicDisplay(1, "Topic1", "Mock1");
        TopicDisplay topic2 = new TopicDisplay(2, "Topic2", "Mock2");
        TopicDisplay topic3 = new TopicDisplay(3, "Topic3", "Mock3");
        List<TopicDisplay> topics = new LinkedList<TopicDisplay>();
        topics.add(topic1);
        topics.add(topic2);
        topics.add(topic3);
        when(topicRepositoryDisplay.findByTopicId()).thenReturn(Optional.of(topics));
        assertTrue(topicService.getTopics() == topics);
        verify(topicRepositoryDisplay).findByTopicId();
    }

    @Test
    void testGetTopicMessages(){
        TopicService topicService = new TopicServiceImpl(topicRepository, topicMessageRepository, topicMessageDisplay, topicRepositoryDisplay);
        TopicMessageDisplay topicMessageDisplay1 = new TopicMessageDisplay(1, "msg1", 0, "MockName1");
        TopicMessageDisplay topicMessageDisplay2 = new TopicMessageDisplay(2, "msg2", 0, "MockName2");
        TopicMessageDisplay topicMessageDisplay3 = new TopicMessageDisplay(3, "msg3", 0, "MockName3");
        List<TopicMessageDisplay> messages = new LinkedList<TopicMessageDisplay>();
        messages.add(topicMessageDisplay1);
        messages.add(topicMessageDisplay2);
        messages.add(topicMessageDisplay3);
        when(topicMessageDisplay.findMessagesByTopicId(1)).thenReturn(Optional.of(messages));
        assertTrue(topicService.getTopicMessages(1) == messages);
        verify(topicMessageDisplay).findMessagesByTopicId(1);
    }
}
