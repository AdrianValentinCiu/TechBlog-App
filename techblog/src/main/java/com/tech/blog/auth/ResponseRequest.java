package com.tech.blog.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ResponseRequest {
    private String email;
    private String password;

    public ResponseRequest(Object email, Object password) {
        this.email = (String)email;
        this.password = (String)password;
    }

    public ResponseRequest() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
