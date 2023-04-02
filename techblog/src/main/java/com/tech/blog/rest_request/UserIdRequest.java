package com.tech.blog.rest_request;

public class UserIdRequest {
    /**
     * This class is used to store the data retriever from the REST Controller
     * The data is converted from JASON to the attributes specified in this class
     */

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
