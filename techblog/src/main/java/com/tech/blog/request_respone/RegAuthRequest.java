package com.tech.blog.request_respone;

public class RegAuthRequest {
    private String email;
    private String password;

    public RegAuthRequest(Object email, Object password) {
        this.email = (String)email;
        this.password = (String)password;
    }

    public RegAuthRequest() {
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
