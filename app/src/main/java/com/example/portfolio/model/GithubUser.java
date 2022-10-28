package com.example.portfolio.model;

public class GithubUser {
    public String login;                // NOMBRE USUARIO
    public String avatar_url;           // FOTO DE PERFIL
    public String html_url;             // URL DEL PERFIL DE GITHUB
    public String name;                 // NOMBRE PUBLICO
    public String blog;                 // INFORMACION QUE AGREGUE EL USUARIO, PUEDEN SER LINKS
    public String location;             // UBICACION DEL USUARIO
    public String email;                // MAIL DEL USUARIO
    public String bio;                  // BIOGRAFIA DEL USUARIO
    public String twitter_username;     // TWITTER DEL USUARIO
    public String public_repos;         // CANTIDAD DE REPOSITORIOS PUBLICOS DEL USUARIO

    public GithubUser(String login, String avatar_url, String html_url, String name, String blog,
                      String location, String email, String bio, String twitter_username, String public_repos)
    {
        this.login = login;
        this.avatar_url = avatar_url;
        this.html_url = html_url;
        this.name = name;
        this.blog = blog;
        this.location = location;
        this.email = email;
        this.bio = bio;
        this.twitter_username = twitter_username;
        this.public_repos = public_repos;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getTwitter_username() {
        return twitter_username;
    }

    public void setTwitter_username(String twitter_username) {
        this.twitter_username = twitter_username;
    }

    public String getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(String public_repos) {
        this.public_repos = public_repos;
    }
}
