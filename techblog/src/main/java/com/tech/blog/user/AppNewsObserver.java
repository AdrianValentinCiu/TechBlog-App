package com.tech.blog.user;

public interface AppNewsObserver {
    /***
     * This class is used to implement the Observer part of the design pattern Observer
     */

    public void notify(String title, String news);
}
