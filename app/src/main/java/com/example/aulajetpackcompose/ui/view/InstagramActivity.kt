package com.example.aulajetpackcompose.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aulajetpackcompose.R
import com.example.aulajetpackcompose.ui.view.componentes.AreaDestaque
import com.example.aulajetpackcompose.ui.view.componentes.AreaPostagem
import com.example.aulajetpackcompose.ui.view.componentes.BarraInferior
import com.example.aulajetpackcompose.ui.view.componentes.BarraSuperior
import com.example.aulajetpackcompose.data.remote.model.Destaque
import com.example.aulajetpackcompose.data.remote.model.Postagem
import com.example.aulajetpackcompose.ui.theme.AulaJetpackComposeTheme
import com.example.aulajetpackcompose.viewmodel.UsuarioViewModel
import dagger.hilt.android.AndroidEntryPoint

private val listaDestaques = listOf(
    Destaque(R.drawable.perfil_01, "José"),
    // ... (restante da lista) ...
)

private val listaPostagens = listOf(
    Postagem(R.drawable.perfil_01, "José", R.drawable.floresta, "Descrição da postagem 1"),
    Postagem(R.drawable.perfil_02, "João", R.drawable.praia, "Descrição da postagem 2"),
    Postagem(R.drawable.perfil_03, "Ana", R.drawable.carro, "Descrição da postagem 3"),
    Postagem(R.drawable.perfil_02, "Pedro", R.drawable.praia, "Descrição da postagem 4"),
)

@AndroidEntryPoint
class InstagramActivity : ComponentActivity() {

    private val usuarioViewModel: UsuarioViewModel by viewModels() // Declarado dentro da Activity

    override fun onStart() {
        super.onStart()
        usuarioViewModel.recuperarUsuarios()
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            AulaJetpackComposeTheme {Scaffold(
                topBar = { BarraSuperior() },
                bottomBar = {
                    BottomAppBar {
                        BarraInferior()
                    }
                },
            ) { paddingIterno ->
                Home(Modifier.padding(paddingIterno))
            }
            }
        }
    }

    @Composable
    fun Home(modifier: Modifier = Modifier) {
        val listaUsuarios by usuarioViewModel.usuarios.observeAsState(initial = emptyList())

        Column(
            modifier = modifier
        ) {
            //Area Destaque
            AreaDestaque(listaUsuarios)
            Divider()
            //Area de Postagens
            AreaPostagem(listaPostagens)
            Divider()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun AppPreview() {
        AulaJetpackComposeTheme {
            Home()
        }
    }
}