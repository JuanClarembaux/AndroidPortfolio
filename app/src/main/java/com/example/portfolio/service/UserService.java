package com.example.portfolio.service;

import com.example.portfolio.model.DBUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @GET("/database/usuarios/{idUsuario}")
    Call<DBUser> getUserById(@Path("idUsuario") int idUsuario);

    @PUT("/database/usuarios/{idUsuario}")
    Call<DBUser> editUserById(@Path("idUsuario") int idUsuario);

    @DELETE("/database/usuarios/{idUsuario}")
    Call<DBUser> deleteUserById(@Path("idUsuario") int idUsuario);

    @POST("/database/usuarios/")
    Call<DBUser> createUser();

}
