package com.example.aulajetpackcompose.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aulajetpackcompose.R
import com.example.aulajetpackcompose.data.model.Usuario
import com.example.aulajetpackcompose.ui.theme.AulaJetpackComposeTheme

class MainActivity : ComponentActivity() {
    
    private val usuarios = listOf(
        Usuario("João", 25),
        Usuario("Maria", 30),
        Usuario("Pedro", 35),
        Usuario("Ana", 40),
        Usuario("Carlos", 45),
        Usuario("Julia", 50),
        Usuario("Lucas", 55),
        Usuario("Isabela", 60),
        Usuario("Rafael", 65),
        Usuario("Mariana", 70),
        Usuario("Gustavo", 75),
        Usuario("Larissa", 80),
        Usuario("Diego", 85),
        Usuario("Camila", 90),
        Usuario("Thiago", 95),
        Usuario("Renata", 100),
        Usuario("Vinicius", 105),
        Usuario("Lari", 110),
        Usuario("Diego", 115),
        Usuario("Camila", 120),
        Usuario("Tiago", 125),
        Usuario("Renata", 130),
        Usuario("Vinicius", 135),
        Usuario("Larissa", 70),
    )

    private val opcoesRadio = listOf(
        "Android", "iOS", "Flutter", "React Native"
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AulaJetpackComposeTheme {
                SegundoApp()
            }//fechamento theme
        }
    }//Fim OnCreate

    @Composable
    fun itemCartao(usuario: Usuario) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            onClick = {
                Toast.makeText(applicationContext, "Clicado", Toast.LENGTH_SHORT).show()
            },
            colors = CardDefaults.cardColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            //shape = RoundedCornerShape(30.dp),
            /*elevation = CardDefaults.cardElevation(
                defaultElevation = 20.dp
            )*/
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp, 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.carro),contentDescription = null,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp),
                    contentScale = ContentScale.Crop)


                Text(text = "${usuario.nome} - ${usuario.idade}",
                    fontSize = 22.sp,
                    modifier = Modifier
                        .padding(start = 16.dp))

            }
        }
    }


    @Composable
    fun SegundoApp(){

        var contador by remember {
            mutableStateOf(0)
        }

        var nome by remember {
            mutableStateOf("")
        }
        var checked by remember {
            mutableStateOf(false)
        }

        var listaUsuarios by remember {
            mutableStateOf(listOf<Usuario>())
        }

        var radioSelecionado by remember {
            mutableStateOf(opcoesRadio[0])
        }
        Column(
            modifier = Modifier
                .background(Color.White)
                .border(2.dp, Color.Red)
                .padding(16.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        ){


            LazyColumn {
                items(usuarios){usuario ->
                    itemCartao(usuario = usuario)
                }
            }


        }
    }
}


/*opcoesRadio.forEach { opcao ->

    /*Row (
      verticalAlignment = Alignment.CenterVertically
    ){
        RadioButton(selected = opcao == radioSelecionado ,
            onClick = {
                radioSelecionado = opcao
            }
        )
        Text(text = opcao)
    }


}

Text(text = "Radio selecionado: $radioSelecionado")*/

//Mais componentes de interface: FAB, CheckBox, Switch, Radio


// Switch(
/*Checkbox(
    modifier = Modifier
        .padding(top = 16.dp),
    checked = checked, onCheckedChange = {alterado ->
    checked = alterado
}
)

Text(text = "alterado: $checked")*/
/*FloatingActionButton(
    containerColor = Color.Magenta,
    contentColor = Color.White,
    onClick = {

}) {
    Icon(painter = painterResource(id = R.drawable.ic_adicionar_24), contentDescription = null )

}*/


/*Row {
    OutlinedTextField(
        value = nome,
        onValueChange = {
                texto ->
            nome = texto
            Log.i("digitado", "digitado: $texto")
        },
        placeholder = {
            Text(text = "Digite seu nome")
        }
    )
    Spacer(modifier = Modifier.width(8.dp))
    Button(onClick = {
            //Adicionar na lista
        val usuario = Usuario(nome, 0)
        listaUsuarios = listaUsuarios + usuario
        nome = ""
    }) {
        Icon(painter = painterResource(id = R.drawable.ic_adicionar_24), contentDescription = null )

    }
}*/// Fim Row

/*LazyColumn(
    modifier = Modifier
        .padding(top = 16.dp, bottom = 16.dp)
) {
    items(listaUsuarios){
        usuario ->
        Text(text = "+) ${usuario.nome}",
        modifier = Modifier
            .padding(8.dp)
            )
        Divider()
    }

}*/

}// fim Column
}// fim metodo segundo app


@Composable
fun PrimeiroApp(){

Column(
modifier = Modifier
    .background(Color.Gray)
    .border(2.dp, Color.Red)
    .padding(30.dp)
    .fillMaxWidth()
    .fillMaxHeight()
) {

//LazyRow
//LazyColumn
/*LazyVerticalGrid(
        //columns = GridCells.Adaptive(122.dp),
        columns = GridCells.Fixed(3),
modifier = Modifier
    .padding(16.dp)
)*/
LazyHorizontalGrid(
    //columns = GridCells.Adaptive(122.dp),
    rows = GridCells.Fixed(3),
    modifier = Modifier
        .padding(16.dp)
        .height(300.dp)
){
    items(usuarios.size) {indice ->
        val nome = usuarios[indice].nome
        val idade = usuarios[indice].idade


    Column {
        Image(
            painter = painterResource(id = R.drawable.carro),contentDescription = null,
            modifier = Modifier
                .width(80.dp)
                .height(80.dp),
            contentScale = ContentScale.Crop)
        Text(text = "$nome")
    }

        /*Row(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.carro),contentDescription = null,
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp),
                contentScale = ContentScale.Crop)


            Text(text = "$nome - $idade",
                fontSize = 32.sp,
                modifier = Modifier
                    .padding(start = 16.dp)

            )
        }*/ //fim row
        /*Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Red)

        )*/
    }
}
/*Image(
    painter = painterResource(id = R.drawable.carro),contentDescription = null,
    modifier = Modifier
        .width(200.dp)
        .height(200.dp)
        .border(2.dp, Color.Red),
    contentScale = ContentScale.Crop
)

Icon(
//painter = painterResource(id = R.drawable.ic_alarme_24)
    imageVector = Icons.Default.Lock,
    contentDescription = null
)

Button(onClick = {}) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = Icons.Default.Lock,
            contentDescription = null
        )
        Text( text = "Desbloquear")
    }
}*/
/*Text(text = "Joséaldo", fontSize = 20.sp)
Column(
    modifier = Modifier
        .width(100.dp)
        .height(100.dp)
        //.clip(CircleShape)
        //.clip(RoundedCornerShape(topStart = 20.dp, topEnd = 8.dp, bottomEnd = 20.dp, bottomStart = 8.dp))
        //.clip(CutCornerShape(topStart = 20.dp, topEnd = 8.dp, bottomEnd = 20.dp, bottomStart = 8.dp))
        //.clip(CutCornerShape(8.dp))
        .border(2.dp, Color.Red, CircleShape)
        .clip(CircleShape)
        .background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
) {
    Text(text = "JA", fontSize = 32.sp)
}*/


}//Fim da Column

/*Column(
modifier = Modifier
    .fillMaxWidth()
    .fillMaxHeight()
    .background(Color.Gray),
verticalArrangement = Arrangement.SpaceAround,
horizontalAlignment = Alignment.CenterHorizontally
//horizontalArrangement = Arrangement.SpaceAround,
//verticalAlignment = Alignment.CenterVertically
) {
Text(text = "Joséaldo", fontSize = 20.sp)
Text(text = "Anderson", fontSize = 20.sp)
Botao(texto = "Teste "){
    println("Botão clicado")
}
*/

}// Fim Column



/*Text(
text = "Meu primeiro App",
color = Color.White
)*/
/*Button(onClick = {}) {
Text(
text = "Meu primeiro App",
color = Color.White
)
}*/


@Preview
@Composable
fun AppPreview(){
SegundoApp()
}
} // fechamento MainActivity

*/