package com.example.portfolio;

public class Project {
    public int projectID;
    public String projectName;
    public String projectURL;

    public Project(){}
    public Project(int projectID, String projectName, String projectURL) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.projectURL = projectURL;
    }

    public int getProjectID() {
        return projectID;
    }
    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String getProjectURL() {
        return projectURL;
    }
    public void setProjectURL(String projectURL) {
        this.projectURL = projectURL;
    }

    public String toString(){
        return projectName;
    }
}
