package com.example.aulajetpackcompose.data.remote.api


import com.example.aulajetpackcompose.data.remote.dto.UsuarioResultado
import retrofit2.Response
import retrofit2.http.GET

interface DummyAPI {
    @GET("users")
    suspend fun recuperarUsuarios(): Response<UsuarioResultado>
}