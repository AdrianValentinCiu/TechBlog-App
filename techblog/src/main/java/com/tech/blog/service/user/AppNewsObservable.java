package com.tech.blog.service.user;

public interface AppNewsObservable {
    /***
     * This interface is used to implement the observable part of the design pattern Observer
     */
    void setNewUpdate(String title, String newUpdate);
}
