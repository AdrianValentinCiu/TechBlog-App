package com.tech.blog.rest_controller;

import com.tech.blog.app_update.AppNewsObservableService;
import com.tech.blog.request_respone.AppNewsRequest;
import org.springframework.http.ResponseEntity;
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

    private final AppNewsObservableService appUpdateService;

    public NewsController(AppNewsObservableService appUpdateService) {
        this.appUpdateService = appUpdateService;
    }

  
    @PostMapping("/new-update")
    public void updateNews(@RequestBody AppNewsRequest request){
        appUpdateService.setNewUpdate(request.getAppNews());

    }


}
