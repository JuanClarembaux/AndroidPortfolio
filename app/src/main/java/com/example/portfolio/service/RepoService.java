package com.example.portfolio.service;

import com.example.portfolio.model.GithubRepo;
import com.example.portfolio.model.GithubUser;
import com.example.portfolio.model.ReposRespuesta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RepoService {

    @GET("/api/usuarios/{login}")
    Call<GithubUser> getGithubUser(@Path("login") String login);

    // http://localhost:3000/api/repositorios/{github_user}/repositorios

    @GET("/users/{login}/repos")
    Call<List<GithubRepo>> getRepos(@Path("login") String login);

    @GET("/api/repositorios/{login}/{name}")
    Call<GithubRepo> getRepoByName(@Path("login") String login, @Path("name") String name);
}