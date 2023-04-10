package com.tech.blog.junit;

public class User {
    private String nume;
    private Risk risk;

    public User(String nume, Risk risk) {
        this.nume = nume;
        this.risk = risk;
    }

    public String getNume() {
        return nume;
    }

    public Risk getRisk() {
        return risk;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }
}
