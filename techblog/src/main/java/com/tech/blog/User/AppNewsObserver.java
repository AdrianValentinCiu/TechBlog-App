package com.tech.blog.User;

public interface AppNewsObserver {
    /***
     * This class is used to implement the Observer part of the design pattern Observer
     */

    public void notify(String title, String news);
}
