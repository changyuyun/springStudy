package com.ityun.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String username;
    private String sex;

    public User() {
    }

    public User(Integer id, String username, String sex) {
        this.id = id;
        this.username = username;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
