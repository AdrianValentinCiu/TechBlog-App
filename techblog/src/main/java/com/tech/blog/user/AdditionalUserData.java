package com.tech.blog.user;

import jakarta.persistence.*;

@Entity
@Table(name = "tbladditionaluserdata")
public class AdditionalUserData {
    /**
     * This class is used to define the data of additional user data in a table in the database
     */

    @Id
    private Integer idAdditionalData;
    private String firstName;
    private String lastName;
    private String info;

    public AdditionalUserData(){}

    public AdditionalUserData(Integer idAdditionalData, String firstName, String lastName, String info) {
        this.idAdditionalData = idAdditionalData;
        this.firstName = firstName;
        this.lastName = lastName;
        this.info = info;
    }

    public Integer getIdAdditionalData() {
        return idAdditionalData;
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

    public void setIdAdditionalData(Integer idAdditionalData) {
        this.idAdditionalData = idAdditionalData;
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

    public String toString(){
        return idAdditionalData + " " + firstName + " " + lastName + " " + info + "\n";
    }
}
