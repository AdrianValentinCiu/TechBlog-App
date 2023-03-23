package com.tech.blog.topic;

import jakarta.persistence.*;

@Entity
@Table(name = "tblmessage")
public class TopicMessage {
    /***
     * This class is used to post a message to a specific topic by a user
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String msgText;
    private Integer likesMessage;
    private Integer idTopic;
    private Integer idUser;

    public TopicMessage(){}

    public TopicMessage(String msgText, Integer idTopic, Integer idUser) {
        this.msgText = msgText;
        this.likesMessage = 0;
        this.idTopic = idTopic;
        this.idUser = idUser;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public String getMsgText() {
        return msgText;
    }

    public Integer getLikesMessage() {
        return likesMessage;
    }

    public Integer getIdTopic() {
        return idTopic;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public void setLikesMessage(Integer likesMessage) {
        this.likesMessage = likesMessage;
    }

    public void setIdTopic(Integer idTopic) {
        this.idTopic = idTopic;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}
