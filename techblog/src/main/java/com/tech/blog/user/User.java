package com.tech.blog.user;

import com.tech.blog.email_send.EmailSender;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tbluser")
public class User implements AppNewsObserver {
    /***
     * This class is used to define the data of a user in a table in the database
     */

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idUser;
    private boolean isOnline;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING) // takes a String values of enum
    private Role userRole;

    public User(boolean isOnline, String email, String password, Role userRole) {
        this.isOnline = isOnline;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public User(Integer idUser, boolean isOnline, String email, String password, Role userRole) {
        this.idUser = idUser;
        this.isOnline = isOnline;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public User() {
    }

    public Integer getIdUser() {
        return idUser;
    }

    public boolean getIsOnline() {
        return isOnline;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return userRole;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setIsOnline(boolean online) {
        isOnline = online;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role userRole) {
        this.userRole = userRole;
    }

    public String toString(){
        return idUser + " " + isOnline + " " + email + " " + password + " " + userRole + "\n";
    }

    /**
     * This method is used to implement the method notify used in the design pattern Observer
     * @param title the title of the user notification via email
     * @param news the body of the user notification via email
     */
    @Override
    public void notify(String title, String news) {
        if(this.userRole == Role.USER){
            EmailSender emailSender = EmailSender.getEmailInstance();
            try {
                emailSender.sendEmail(this.email, title, news);
            }
            catch (Exception e){
                System.out.println(e.getCause());
            }
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isOnline == user.isOnline && Objects.equals(idUser, user.idUser) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && userRole == user.userRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, isOnline, email, password, userRole);
    }
}
