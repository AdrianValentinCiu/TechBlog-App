package com.tech.blog.rest_controller;

import com.tech.blog.service.user.AppNewsObservable;
import com.tech.blog.rest_request.AppNewsRequest;
import com.tech.blog.service.user.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {
    /**
     * This class is used to implement the REST controller to give an email with the news to all the users
     * @param appUpdateService is used to use the functionality implemented
     */

    private final AppNewsObservable userService;

    public NewsController(AppNewsObservable userService) {
        this.userService = userService;
    }

    @PostMapping("/new-update")
    public void updateNews(@RequestBody AppNewsRequest request){
        userService.setNewUpdate(request.getTitle(), request.getAppNews());
    }


}
