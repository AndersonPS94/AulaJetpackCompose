package com.example.aulajetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.aulajetpackcompose.componentes.AreaDestaque
import com.example.aulajetpackcompose.componentes.AreaPostagem
import com.example.aulajetpackcompose.componentes.BarraInferior

import com.example.aulajetpackcompose.componentes.BarraSuperior
import com.example.aulajetpackcompose.model.Destaque
import com.example.aulajetpackcompose.model.Postagem
import com.example.aulajetpackcompose.ui.theme.AulaJetpackComposeTheme

class InstagramActivity : ComponentActivity() {

    private val listaDestaques = listOf(
        Destaque(R.drawable.perfil_01, "José"),
        Destaque(R.drawable.perfil_02, "Maria"),
        Destaque(R.drawable.perfil_03, "João"),
        Destaque(R.drawable.perfil_02, "Ana"),
        Destaque(R.drawable.perfil_01, "Pedro"),
        Destaque(R.drawable.perfil_01, "José"),
        Destaque(R.drawable.perfil_02, "Maria"),
        Destaque(R.drawable.perfil_03, "João"),
        Destaque(R.drawable.perfil_02, "Ana"),
        Destaque(R.drawable.perfil_01, "Pedro"),
        Destaque(R.drawable.perfil_01, "José"),
        Destaque(R.drawable.perfil_02, "Maria"),
        Destaque(R.drawable.perfil_03, "João"),
        Destaque(R.drawable.perfil_02, "Ana"),
        Destaque(R.drawable.perfil_01, "Pedro"),
        Destaque(R.drawable.perfil_01, "José"),
        Destaque(R.drawable.perfil_02, "Maria"),
        Destaque(R.drawable.perfil_03, "João"),
        Destaque(R.drawable.perfil_02, "Ana"),
        Destaque(R.drawable.perfil_01, "Pedro"),
        Destaque(R.drawable.perfil_01, "José"),
        Destaque(R.drawable.perfil_02, "Maria"),
        Destaque(R.drawable.perfil_03, "João"),
        Destaque(R.drawable.perfil_02, "Ana"),
        Destaque(R.drawable.perfil_01, "Pedro"),

    )

    private val listaPostagens = listOf(
        Postagem(R.drawable.perfil_01, "José", R.drawable.floresta, "Descrição da postagem 1"),
        Postagem(R.drawable.perfil_02, "Maria", R.drawable.praia, "Descrição da postagem 2"),
        Postagem(R.drawable.perfil_03, "João", R.drawable.carro, "Descrição da postagem 3"),
        Postagem(R.drawable.perfil_02, "Ana", R.drawable.praia, "Descrição da postagem 4"),
        Postagem(R.drawable.perfil_01, "Pedro", R.drawable.floresta, "Descrição da postagem 5"),
        Postagem(R.drawable.perfil_01, "José", R.drawable.floresta, "Descrição da postagem 1"),
        Postagem(R.drawable.perfil_02, "Maria", R.drawable.praia, "Descrição da postagem 2"),
        Postagem(R.drawable.perfil_03, "João", R.drawable.carro, "Descrição da postagem 3"),
        Postagem(R.drawable.perfil_02, "Ana", R.drawable.praia, "Descrição da postagem 4"),
        Postagem(R.drawable.perfil_01, "Pedro", R.drawable.floresta, "Descrição da postagem 5"),
        Postagem(R.drawable.perfil_01, "José", R.drawable.floresta, "Descrição da postagem 1"),
    )

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            AulaJetpackComposeTheme {
                Scaffold (
                    topBar = { BarraSuperior()},
                    bottomBar = {
                        BottomAppBar{
                            BarraInferior()
                        }
                    },
                    /*floatingActionButton = {
                        FloatingActionButton(onClick = {}) {
                            Icon(painter = painterResource(id = R.drawable.ic_adicionar_24), contentDescription = null
                            )
                        }
                    },*/
                    //floatingActionButtonPosition = FabPosition.End
                ){ paddingIterno ->
                    Home(Modifier.padding(paddingIterno))
                    }
                }
            }
        }
    }//Fim OnCreate


    @Composable
    fun Home(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
        ) {
            //Area Destaque
            AreaDestaque(listaDestaques = listaDestaques)

            Divider()
            //Area de Postagens
            AreaPostagem(listaPostagens = listaPostagens)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun AppPreview() {
        AulaJetpackComposeTheme {
            Home()
        }
    }
//Fim da Activity
