package com.tech.blog.RestRequest;

public class TopicRequest {
    /**
     * This class is used to store the data retriever from the REST Controller for the registration of a new user
     * The data is converted from JASON to the attributes specified in this class
     */
    private String topicTitle;
    private Integer idUserPostAdmin;

    public TopicRequest(){}

    public TopicRequest(String topicTitle, Integer idUserPostAdmin) {
        this.topicTitle = topicTitle;
        this.idUserPostAdmin = idUserPostAdmin;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public Integer getIdUserPostAdmin() {
        return idUserPostAdmin;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public void setIdUserPostAdmin(Integer idUserPostAdmin) {
        this.idUserPostAdmin = idUserPostAdmin;
    }
}
