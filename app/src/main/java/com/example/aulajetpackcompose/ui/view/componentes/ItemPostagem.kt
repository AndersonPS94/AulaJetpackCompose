package com.example.aulajetpackcompose.ui.view.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.aulajetpackcompose.data.remote.model.Destaque
import com.example.aulajetpackcompose.data.remote.model.Postagem

@Composable
fun ItemPostagem(
    postagem: Postagem,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .padding(top = 8.dp, bottom = 8.dp)
    ) {

        //informacoes de perfil

        Row(
            modifier = Modifier.padding(16.dp, 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {


            Image(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape),
                painter = painterResource(id = postagem.imagemPerfilRes), contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text(text = postagem.nome,
                modifier = Modifier.padding(start = 8.dp),
                style = MaterialTheme.typography.titleMedium)
            //informacoes de postagem
        }
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(id = postagem.fotoRes), contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text(text = postagem.descricao, style = MaterialTheme.typography.titleMedium)

    }
}