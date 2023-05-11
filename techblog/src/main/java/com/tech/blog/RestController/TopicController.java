package com.tech.blog.RestController;

import com.tech.blog.RestRequest.TopicLikeMessageRequest;
import com.tech.blog.RestRequest.TopicMessageRequest;
import com.tech.blog.RestRequest.TopicRequest;
import com.tech.blog.Service.Topic.TopicService;
import com.tech.blog.Topic.TopicDisplay;
import com.tech.blog.Topic.TopicMessageDisplay;
import jdk.jshell.spi.ExecutionControl;
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
    public List<TopicDisplay> getTopics(){
        return topicService.getTopics();

    }

    /**
     * This method is used to return the messages from a topic
     * @return a list with all the messages from a specific topic
     */
    @GetMapping("/topic-messages/{topic_id}")
    public List<TopicMessageDisplay> getTopicMessages(@PathVariable Integer topic_id){
        return topicService.getTopicMessages(topic_id);

    }

    /**
     * This method is used to create a new topic
     * @param request decoded data from JASON format
     * @return a boolean representing the state of the topic
     */
    @PostMapping("/create-topic")
    public ResponseEntity<Integer> createTopic(@RequestBody TopicRequest request){
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
    public Integer likeMsgOnTopic(@RequestBody TopicLikeMessageRequest request){
        return topicService.likeMsgOnTopic(request.getIdMessage(), request.getIdTopic());
    }

}
