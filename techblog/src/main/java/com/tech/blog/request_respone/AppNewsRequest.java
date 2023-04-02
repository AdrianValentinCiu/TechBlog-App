package com.tech.blog.request_respone;

public class AppNewsRequest {
    /**
     * This class is used to store the data retriever from the REST Controller for the registration of new news about the app
     * The data is converted from JASON to the attributes specified in this class
     */

    private String appNews;

    public AppNewsRequest(String appNews) {
        this.appNews = appNews;
    }

    public String getAppNews() {
        return appNews;
    }

    public void setAppNews(String appNews) {
        this.appNews = appNews;
    }
}
