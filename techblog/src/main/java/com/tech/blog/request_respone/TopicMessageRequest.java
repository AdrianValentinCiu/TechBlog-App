package com.tech.blog.request_respone;

public class TopicMessageRequest {
    /**
     * This class is used to store the data retriever from the REST Controller for the registration of a new user
     * The data is converted from JASON to the attributes specified in this class
     */
    private String msgText;
    private Integer idTopic;
    private Integer idUser;

    public TopicMessageRequest(){}

    public TopicMessageRequest(String msgTxt, Integer idTopic, Integer idUser) {
        this.msgText = msgTxt;
        this.idTopic = idTopic;
        this.idUser = idUser;
    }

    public String getMsgText() {
        return msgText;
    }

    public Integer getIdTopic() {
        return idTopic;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setMsgText(String msgTxt) {
        this.msgText = msgTxt;
    }

    public void setIdTopic(Integer idTopic) {
        this.idTopic = idTopic;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}
