package com.tech.blog.RestRequest;

public class AppNewsRequest {
    /**
     * This class is used to store the data retriever from the REST Controller for the registration of new news about the app
     * The data is converted from JASON to the attributes specified in this class
     */

    private String title;
    private String appNews;

    public AppNewsRequest(String title, String appNews) {
        this.title = title;
        this.appNews = appNews;
    }

    public AppNewsRequest(){}

    public String getTitle() {
        return title;
    }

    public String getAppNews() {
        return appNews;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAppNews(String appNews) {
        this.appNews = appNews;
    }
}
