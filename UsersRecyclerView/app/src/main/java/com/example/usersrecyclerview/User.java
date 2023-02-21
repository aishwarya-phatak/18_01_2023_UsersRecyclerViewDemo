package com.example.usersrecyclerview;

import java.io.Serializable;

public class User implements Serializable {
    int userId;
    int imageId;
    String username;

    public User(int userid, int imageId,String username){
        this.userId = userid;
        this.imageId = imageId;
        this.username = username;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public int getImageId() {
        return imageId;
    }

    public String getUsername() {
        return username;
    }
}
