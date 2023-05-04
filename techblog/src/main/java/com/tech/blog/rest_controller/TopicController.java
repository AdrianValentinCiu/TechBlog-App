package com.tech.blog.rest_controller;

import com.tech.blog.rest_request.TopicLikeMessageRequest;
import com.tech.blog.rest_request.TopicMessageRequest;
import com.tech.blog.rest_request.TopicRequest;
import com.tech.blog.service.topic.TopicService;
import com.tech.blog.topic.Topic;
import com.tech.blog.topic.TopicMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic")
@CrossOrigin("*")
public class TopicController {
    /**
     * This class is used to implement the REST controller, using the endpoints: GET, POST, PUT, DELETE
     * @param topicService is used to use the functionality implemented
     */

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    /**
     * This method is used to retreive all the topics
     * @return a list with all the topics form the database
     */
    @GetMapping("/topics")
    public List<Topic> getTopics(){
        return topicService.getTopics();

    }

    /**
     * This method is used to return the messages from a topic
     * @return a list with all the messages from a specific topic
     */
    @GetMapping("/topic-messages/{topic_id}")
    public List<TopicMessage> getTopicMessages(@PathVariable Integer topic_id){
        return topicService.getTopicMessages(topic_id);

    }

    /**
     * This method is used to create a new topic
     * @param request decoded data from JASON format
     * @return a boolean representing the state of the topic
     */
    @PostMapping("/create-topic")
    public ResponseEntity<Boolean> createTopic(@RequestBody TopicRequest request){
        return ResponseEntity.ok(topicService.createTopic(request.getTopicTitle(), request.getIdUserPostAdmin()));

    }

    /**
     * This method is used to post a message on a topic
     * @param request decoded data from JASON format
     * @return a boolean representing the state of the message sent on a topic
     */
    @PostMapping("/post-message-topic")
    public ResponseEntity<Boolean> postMsgOnTopic(@RequestBody TopicMessageRequest request){
        return ResponseEntity.ok(topicService.postMsgOnTopic(request.getIdTopic(), request.getMsgText(), request.getIdUser()));
    }

    /**
     * This method is used to increment the liking of a message from a post
     * @param request decoded data from JASON format
     * @return a boolean representing the state of the liked message by a user
     */
    @PutMapping("/like-topic-message")
    public ResponseEntity<Boolean> likeMsgOnTopic(@RequestBody TopicLikeMessageRequest request){
        return ResponseEntity.ok(topicService.likeMsgOnTopic(request.getIdMessage(), request.getIdTopic(), request.getIdUser()));
    }

}
