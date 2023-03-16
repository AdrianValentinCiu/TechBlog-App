package com.tech.blog.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DeAuthenticationRequest {
    private Integer id;

    public DeAuthenticationRequest(Object id) {
        this.id = (Integer)id;
    }

    public DeAuthenticationRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
