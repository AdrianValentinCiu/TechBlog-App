package com.tech.blog.rest_controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

    @PostMapping("/create-topic")
    public void createTopic(){

    }

    @PostMapping("post-message-topic")
    public void postMsgtoTopic(){

    }

}
