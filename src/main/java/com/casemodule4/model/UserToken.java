package com.casemodule4.model;

import lombok.Data;

@Data
public class UserToken {
    private String token;
    private int id;
    private String roleName;

    public UserToken() {
    }

    public UserToken(String token, int id, String roleName) {
        this.token = token;
        this.id = id;
        this.roleName = roleName;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
