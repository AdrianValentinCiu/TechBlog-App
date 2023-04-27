package com.tech.blog.user;

import jakarta.persistence.*;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalUserData that = (AdditionalUserData) o;
        return Objects.equals(idAdditionalData, that.idAdditionalData) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAdditionalData, firstName, lastName, info);
    }
}
