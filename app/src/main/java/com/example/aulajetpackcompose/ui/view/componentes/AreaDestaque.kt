package com.example.aulajetpackcompose.ui.view.componentes

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.aulajetpackcompose.data.model.Destaque


@Composable
fun AreaDestaque(
    listaDestaques: List<Destaque>,
    modifier: Modifier = Modifier
){
    LazyRow(
        modifier = modifier
    ){
        items(listaDestaques){ destaque ->
            ItemDestaque(destaque = destaque)
        }
    }
}
