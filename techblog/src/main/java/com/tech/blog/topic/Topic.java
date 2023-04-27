package com.tech.blog.topic;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tbltopic")
public class Topic {
    /***
     * This class is used to define the topic created by a user in a table in the database
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idTopic;
    private String topicTitle;
    private Integer idUserPostAdmin;

    public Topic(){}

    public Topic(String topicTitle, Integer idUserPostAdmin) {
        this.topicTitle = topicTitle;
        this.idUserPostAdmin = idUserPostAdmin;
    }

    public String getIdTopic() {
        return idTopic;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public Integer getIdUserPostAdmin() {
        return idUserPostAdmin;
    }

    public void setIdTopic(String idTopic) {
        this.idTopic = idTopic;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public void setIdUserPostAdmin(Integer idUserPostAdmin) {
        this.idUserPostAdmin = idUserPostAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return Objects.equals(idTopic, topic.idTopic) && Objects.equals(topicTitle, topic.topicTitle) && Objects.equals(idUserPostAdmin, topic.idUserPostAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTopic, topicTitle, idUserPostAdmin);
    }
}
