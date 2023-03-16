package com.tech.blog.request_respone;

public class UserIdRequest {
    private Integer id;

    public UserIdRequest(Object id) {
        this.id = (Integer)id;
    }

    public UserIdRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
