package com.tech.blog.RestRequest;

public class TopicLikeMessageRequest {
    /**
     * This class is used to store the data retriever from the REST Controller for the registration of a new user
     * The data is converted from JASON to the attributes specified in this class
     */
    private Integer idMessage;
    private Integer idTopic;

    public TopicLikeMessageRequest(){}

    public TopicLikeMessageRequest(Integer idMessage, Integer idTopic) {
        this.idMessage = idMessage;
        this.idTopic = idTopic;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public Integer getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Integer idTopic) {
        this.idTopic = idTopic;
    }
}
