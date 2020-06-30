package com.ityun.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Document(indexName = "es_user_test", type = "user")
public class EsUser implements Serializable {

    private static final long serialVersionUID = 6320548148250372657L;

    @Id
    private String id;

    @Field(type = FieldType.keyword)
    private String username;

    @Field(type = FieldType.keyword)
    private String describe;

    public EsUser() {
    }

    public EsUser(String id, String username, String describe) {
        this.id = id;
        this.username = username;
        this.describe = describe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "EsUser{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}
