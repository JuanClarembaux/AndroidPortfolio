package com.example.portfolio.model;

public class User {
    public int userID;
    public String userName;
    public String userMail;
    public String password;
    public String userPhone;

    public User(){}
    public User(int userID, String userName, String userMail, String password, String userPhone) {
        this.userID = userID;
        this.userName = userName;
        this.userMail = userMail;
        this.password = password;
        this.userPhone = userPhone;
    }

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserMail() {
        return userMail;
    }
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
    public String getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
