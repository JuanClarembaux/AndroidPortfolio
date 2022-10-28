package com.example.portfolio.model;

public class DBUser {
    public int idUsuario;
    public String nombreUsuario;
    public String apellidoUsuario;
    public String ocupacionUsuario;
    public String gmailUsuario;
    public String linkedinUsuario;
    public String githubUsuario;
    public String contrasenaUsuario;
    public String createdAt;
    public String updatedAt;

    public DBUser(){}
    public DBUser(int idUsuario, String nombreUsuario, String apellidoUsuario, String ocupacionUsuario, String gmailUsuario, String linkedinUsuario, String githubUsuario, String contrasenaUsuario, String createdAt, String updatedAt) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.ocupacionUsuario = ocupacionUsuario;
        this.gmailUsuario = gmailUsuario;
        this.linkedinUsuario = linkedinUsuario;
        this.githubUsuario = githubUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getOcupacionUsuario() {
        return ocupacionUsuario;
    }

    public void setOcupacionUsuario(String ocupacionUsuario) {
        this.ocupacionUsuario = ocupacionUsuario;
    }

    public String getGmailUsuario() {
        return gmailUsuario;
    }

    public void setGmailUsuario(String gmailUsuario) {
        this.gmailUsuario = gmailUsuario;
    }

    public String getLinkedinUsuario() {
        return linkedinUsuario;
    }

    public void setLinkedinUsuario(String linkedinUsuario) {
        this.linkedinUsuario = linkedinUsuario;
    }

    public String getGithubUsuario() {
        return githubUsuario;
    }

    public void setGithubUsuario(String githubUsuario) {
        this.githubUsuario = githubUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}