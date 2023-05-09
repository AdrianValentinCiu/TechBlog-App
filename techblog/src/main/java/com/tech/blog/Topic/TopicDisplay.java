package com.tech.blog.Topic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class TopicDisplay {
    /***
     * This class is used to retreive all the data about a topic from the database
     */
    @Id
    private Integer idTopic;
    private String topicTitle;
    private String fullName;

    public TopicDisplay(){}

    public TopicDisplay(Integer idTopic, String topicTitle, String fullName) {
        this.idTopic = idTopic;
        this.topicTitle = topicTitle;
        this.fullName = fullName;
    }

    public Integer getIdTopic() {
        return idTopic;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public String getFullName() {
        return fullName;
    }

    public void setIdTopic(Integer idTopic) {
        this.idTopic = idTopic;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicDisplay that = (TopicDisplay) o;
        return Objects.equals(idTopic, that.idTopic) && Objects.equals(topicTitle, that.topicTitle) && Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTopic, topicTitle, fullName);
    }
}
