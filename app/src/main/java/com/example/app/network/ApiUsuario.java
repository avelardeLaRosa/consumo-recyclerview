package com.example.app.network;

import com.example.app.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiUsuario {

    @GET("usuarios")
    Call<List<Usuario>> getUsuarios();

}
