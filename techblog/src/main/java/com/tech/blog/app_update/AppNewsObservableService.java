package com.tech.blog.app_update;

import com.tech.blog.dao.UserRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AppNewsObservableService implements AppUserObservable{
    private final UserRepository userRepository;
    private List<AppNewsObserver> notifyUserAppUpdates;

    public AppNewsObservableService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.notifyUserAppUpdates = new LinkedList<>();
    }

    @Override
    public void addObserver(AppNewsObserver notifyUserAppUpdate){
        this.notifyUserAppUpdates.add(notifyUserAppUpdate);
    }

    @Override
    public void removeObserver(AppNewsObserver notifyUserAppUpdate){
        this.notifyUserAppUpdates.remove(notifyUserAppUpdate);
    }
    @Override
    public void setNewUpdate(String newUpdate){
        for(AppNewsObserver notifyUserAppUpdate : userRepository.findAll())
        {
            notifyUserAppUpdate.notify(newUpdate);
        }
    }
}
