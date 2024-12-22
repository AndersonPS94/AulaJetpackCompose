package com.example.aulajetpackcompose.ui.view.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.aulajetpackcompose.data.remote.dto.User
import com.example.aulajetpackcompose.data.remote.model.Destaque

@Composable
fun ItemDestaque(
    usuario: User,
    modifier: Modifier = Modifier
) {

        Column(
            modifier = modifier.padding(horizontal = 8.dp)
        ) {
            AsyncImage(
                model = usuario.image,
                modifier = Modifier
                    .background(Color.LightGray,CircleShape)
                    .size(56.dp)
                    .clip(CircleShape),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
                Text(
                    modifier = Modifier.padding(top = 8.dp, start = 6.dp),
                    text = usuario.firstName,
                    style = MaterialTheme.typography.titleMedium
                )
        }
}