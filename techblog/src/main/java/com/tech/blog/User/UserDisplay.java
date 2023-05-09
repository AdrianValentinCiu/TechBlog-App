package com.tech.blog.User;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class UserDisplay {
    /***
     * This class is used retreive all the data about a user from the database
     */

    @Id
    private Integer idUser;
    private boolean isOnline;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING) // takes a String values of enum
    private Role userRole;
    private String fullName;
    private String info;

    public UserDisplay(){}

    public UserDisplay(Integer idUser, boolean isOnline, String email, String password, Role userRole, String fullName, String info) {
        this.idUser = idUser;
        this.isOnline = isOnline;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.fullName = fullName;
        this.info = info;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getUserRole() {
        return userRole;
    }

    public String getFullName() {
        return fullName;
    }

    public String getInfo() {
        return info;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDisplay that = (UserDisplay) o;
        return isOnline == that.isOnline && Objects.equals(idUser, that.idUser) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && userRole == that.userRole && Objects.equals(fullName, that.fullName) && Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, isOnline, email, password, userRole, fullName, info);
    }
}
