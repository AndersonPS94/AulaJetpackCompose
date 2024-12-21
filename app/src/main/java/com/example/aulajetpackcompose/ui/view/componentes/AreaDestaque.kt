package com.example.aulajetpackcompose.ui.view.componentes

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.aulajetpackcompose.data.remote.dto.User
import com.example.aulajetpackcompose.data.remote.model.Destaque


@Composable
fun AreaDestaque(
    listaUsuarios: List<User>,
    modifier: Modifier = Modifier
){
    LazyRow(
        modifier = modifier
    ){
        items(listaUsuarios){ usuario ->
            ItemDestaque(usuario)
        }
    }
}
