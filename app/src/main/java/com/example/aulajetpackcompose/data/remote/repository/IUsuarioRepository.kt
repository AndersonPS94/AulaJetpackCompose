package com.example.aulajetpackcompose.data.remote.repository

import com.example.aulajetpackcompose.data.remote.dto.User

interface IUsuarioRepository {
    suspend fun recuperarUsuarios(): List<User>
}