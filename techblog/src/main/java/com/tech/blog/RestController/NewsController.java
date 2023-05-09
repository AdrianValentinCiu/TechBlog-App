package com.tech.blog.RestController;

import com.tech.blog.Service.User.AppNewsObservable;
import com.tech.blog.RestRequest.AppNewsRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
@CrossOrigin("*")
public class NewsController {
    /**
     * This class is used to implement the REST controller to give an email with the news to all the users
     * @param appUpdateService is used to use the functionality implemented
     */

    private final AppNewsObservable userService;

    public NewsController(AppNewsObservable userService) {
        this.userService = userService;
    }

    /**
     * This method is used to email all users using the design pattern Observer
     * @param request decoded data from JASON format
     */
    @PostMapping("/new-update")
    public void updateNews(@RequestBody AppNewsRequest request){
        userService.setNewUpdate(request.getTitle(), request.getAppNews());
    }


}
