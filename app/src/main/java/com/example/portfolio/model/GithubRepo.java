package com.example.portfolio.model;

public class GithubRepo {
    public String name;                 // NOMBRE DEL REPOSITORIO
    public String full_name;            // NOMBRE DEL USUARIO + NOMBRE DEL REPOSITORIO
    public String html_url;             // URL DEL REPOSITORIO
    public String description;          // DESCRIPCION DEL REPOSITORIO
    public String created_at;           // FECHA DE CREACION DEL REPOSITORIO
    public String updated_at;           // FECHA DE ULTIMA ACTUALIZACION DEL REPOSITORIO
    public String pushed_at;            // FECHA DEL ULTIMO PUSH AL REPOSITORIO
    public String clone_url;            // URL DE CLONACION
    public String language;             // LENGUAJE PRINCIPAL DEL PROYECTO
    public String visibility;           // VISIBILIDAD DEL REPOSITORIO
    public String default_branch;       // RAMA PRINCIPAL DEL REPOSITORIO

    public GithubRepo(String name, String full_name, String html_url, String description, String created_at,
                      String updated_at, String pushed_at, String clone_url, String language, String visibility, String default_branch)
    {
        this.name = name;
        this.full_name = full_name;
        this.html_url = html_url;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.pushed_at = pushed_at;
        this.clone_url = clone_url;
        this.language = language;
        this.visibility = visibility;
        this.default_branch = default_branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getPushed_at() {
        return pushed_at;
    }

    public void setPushed_at(String pushed_at) {
        this.pushed_at = pushed_at;
    }

    public String getClone_url() {
        return clone_url;
    }

    public void setClone_url(String clone_url) {
        this.clone_url = clone_url;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getDefault_branch() {
        return default_branch;
    }

    public void setDefault_branch(String default_branch) {
        this.default_branch = default_branch;
    }
    public String toString(){
        return name;
    }
}
