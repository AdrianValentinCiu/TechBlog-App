package com.tech.blog.request_respone;

public class UserData {
    /**
     * This class is used to store the data retriever from the REST Controller
     * The data is converted from JASON to the attributes specified in this class
     */

    private Integer userId;
    private String firstName;
    private String lastName;
    private String info;

    public UserData(){}

    public UserData(Integer userId, String firstName, String lastName, String info) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.info = info;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getInfo() {
        return info;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
