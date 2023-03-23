package com.tech.blog.request_respone;

public class TopicLikeMessageRequest {
    /**
     * This class is used to store the data retriever from the REST Controller for the registration of a new user
     * The data is converted from JASON to the attributes specified in this class
     */
    private Integer idMessage;
    private Integer idTopic;
    private Integer idUser;

    public TopicLikeMessageRequest(){}

    public TopicLikeMessageRequest(Integer idMessage, Integer idTopic, Integer idUser) {
        this.idMessage = idMessage;
        this.idTopic = idTopic;
        this.idUser = idUser;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public void setIdTopic(Integer idTopic) {
        this.idTopic = idTopic;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public Integer getIdTopic() {
        return idTopic;
    }

    public Integer getIdUser() {
        return idUser;
    }
}
