package com.tech.blog.RestRequest;

public class RegAuthRequest {
    /**
     * This class is used to store the data retriever from the REST Controller for the registration of a new user
     * The data is converted from JASON to the attributes specified in this class
     */

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
