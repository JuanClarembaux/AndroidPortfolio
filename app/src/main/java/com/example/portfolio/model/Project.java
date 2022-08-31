package com.example.portfolio.model;

public class Project {
    public int projectID;
    public String projectName;
    public String projectURL;
    public String projectLanguage;
    public String projectDescription;
    public String projectOwner;
    public String projectCollaborators;
    public String projectType;

    public Project(){}
    public Project(int projectID, String projectName, String projectURL, String projectLanguage, String projectDescription, String projectOwner, String projectCollaborators, String projectType) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.projectURL = projectURL;
        this.projectLanguage = projectLanguage;
        this.projectDescription = projectDescription;
        this.projectOwner = projectOwner;
        this.projectCollaborators = projectCollaborators;
        this.projectType = projectType;
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

    public String getProjectLanguage() {
        return projectLanguage;
    }
    public void setProjectLanguage(String projectLanguage) {
        this.projectLanguage = projectLanguage;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(String projectOwner) {
        this.projectOwner = projectOwner;
    }

    public String getProjectCollaborators() {
        return projectCollaborators;
    }

    public void setProjectCollaborators(String projectCollaborators) {
        this.projectCollaborators = projectCollaborators;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String toString(){
        return projectName;
    }
}
