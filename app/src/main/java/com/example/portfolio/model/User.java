package com.example.portfolio.model;

public class User {
    public int userID;
    public String userName;
    public String userMail;
    public int userPhone;

    public User(){}
    public User(int userID, String userName, String userMail, int userPhone) {
        this.userID = userID;
        this.userName = userName;
        this.userMail = userMail;
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
    public String getUserMail() {
        return userMail;
    }
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
    public int getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(int userPhone) {
        this.userPhone = userPhone;
    }
}
