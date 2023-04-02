package com.tech.blog.app_update;

public interface AppUserObservable {
    public void addObserver(AppNewsObserver notifyUserAppUpdate);
    public void removeObserver(AppNewsObserver notifyUserAppUpdate);
    public void setNewUpdate(String newUpdate);
}
