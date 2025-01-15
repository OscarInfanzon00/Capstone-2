package com.infanzon.collaborativestorybuilder.DataClasses;

public class User {
    private String userId;
    private String username;
    private String email;
    private int userLvL;


    // Constructor
    public User(String userId, String username, String email, int userLvL) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.userLvL = userLvL;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserLvL() {
        return userLvL;
    }

    public void setUserLvL(int userLvL) {
        this.userLvL = userLvL;
    }
}
