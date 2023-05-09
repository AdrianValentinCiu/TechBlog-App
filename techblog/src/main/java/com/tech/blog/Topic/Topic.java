package com.tech.blog.Topic;

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
    private Integer idTopic;
    private String topicTitle;
    private Integer idUserPostAdmin;

    public Topic(){}

    public Topic(String topicTitle, Integer idUserPostAdmin) {
        this.topicTitle = topicTitle;
        this.idUserPostAdmin = idUserPostAdmin;
    }

    public Topic(Integer idTopic, String topicTitle, Integer idUserPostAdmin) {
        this.idTopic = idTopic;
        this.topicTitle = topicTitle;
        this.idUserPostAdmin = idUserPostAdmin;
    }

    public Integer getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Integer idTopic) {
        this.idTopic = idTopic;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public Integer getIdUserPostAdmin() {
        return idUserPostAdmin;
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
