package com.example.portfolio.service;

import com.example.portfolio.model.DBUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @GET("/database/usuario/{idUsuario}")
    Call<DBUser> getUserById(@Path("idUsuario") int idUsuario);

    @PUT("/database/usuario/{idUsuario}")
    Call<DBUser> editUserById(@Path("idUsuario") int idUsuario, @Body DBUser dbUser);

    @POST("/database/usuario/")
    Call<DBUser> createUser(@Body DBUser dbUser);

    @POST("/database/usuario/login")
    Call<DBUser> login(@Body DBUser dbUser) ;

}
