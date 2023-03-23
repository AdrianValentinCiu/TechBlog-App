package com.tech.blog.rest_controller;

import com.tech.blog.request_respone.TopicLikeMessageRequest;
import com.tech.blog.request_respone.TopicMessageRequest;
import com.tech.blog.request_respone.TopicRequest;
import com.tech.blog.service.TopicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topic")
public class TopicController {
    /**
     * This class is used to implement the REST controller, using the endpoints: GET, POST, PUT, DELETE
     * @param topicService is used to use the functionality implemented
     */

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping("/create-topic")
    public ResponseEntity<Boolean> createTopic(@RequestBody TopicRequest request){
        return ResponseEntity.ok(topicService.createTopic(request.getTopicTitle(), request.getIdUserPostAdmin()));

    }

    @PostMapping("/post-message-topic")
    public ResponseEntity<Boolean> postMsgOnTopic(@RequestBody TopicMessageRequest request){
        return ResponseEntity.ok(topicService.postMsgOnTopic(request.getIdTopic(), request.getMsgText(), request.getIdUser()));
    }

    @PutMapping("/like-topic-message")
    public ResponseEntity<Boolean> likeMsgOnTopic(@RequestBody TopicLikeMessageRequest request){
        return ResponseEntity.ok(topicService.likeMsgOnTopic(request.getIdMessage(), request.getIdTopic(), request.getIdUser()));
    }

}
