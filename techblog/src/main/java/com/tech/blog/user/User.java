package com.tech.blog.user;

import jakarta.persistence.*;

@Entity
@Table(name = "tbluser")
public class User {
    @Id
    private Integer idUser;
    private boolean isOnline;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING) // takes a String values of enum
    private Role role;

    public User(Integer idUser, boolean isOnline, String email, String password, Role role) {
        this.idUser = idUser;
        this.isOnline = isOnline;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User() {
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

    public Role getRole() {
        return role;
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

    public void setRole(Role role) {
        this.role = role;
    }
}
