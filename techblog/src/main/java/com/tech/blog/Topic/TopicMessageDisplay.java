package com.tech.blog.Topic;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class TopicMessageDisplay {
    /***
     * This class is used to retreive ll the data about a topic message from the database
     */
    @Id
    private Integer idMessage;
    private String msgText;
    private Integer likesMessage;
    private String fullName;

    public TopicMessageDisplay(Integer idMessage, String msgText, Integer likesMessage, String fullName) {
        this.idMessage = idMessage;
        this.msgText = msgText;
        this.likesMessage = likesMessage;
        this.fullName = fullName;
    }

    public TopicMessageDisplay(){}

    public Integer getIdMessage() {
        return idMessage;
    }

    public String getMsgText() {
        return msgText;
    }

    public Integer getLikesMessage() {
        return likesMessage;
    }

    public String getfullName() {
        return fullName;
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

    public void setfullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicMessageDisplay that = (TopicMessageDisplay) o;
        return Objects.equals(idMessage, that.idMessage) && Objects.equals(msgText, that.msgText) && Objects.equals(likesMessage, that.likesMessage) && Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMessage, msgText, likesMessage, fullName);
    }
}

