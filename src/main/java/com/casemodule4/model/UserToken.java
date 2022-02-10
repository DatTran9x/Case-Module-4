package com.casemodule4.model;

public class UserToken {
    private String token;
    private int id;

    public UserToken() {
    }

    public UserToken(String token, int id) {
        this.token = token;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
