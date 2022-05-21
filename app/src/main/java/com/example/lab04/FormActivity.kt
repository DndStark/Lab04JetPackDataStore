package com.example.lab04
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lab04.navegation.AppScreens

private val form: List<String> = listOf(
    "Periodo académico",
    "Escuela profesional",
    "Código de asignatura",
    "Nombre de asignatura",
    "Semestre",
    "Duración"
)
private var periodo: String = ""
private var escuela: String  = ""
private var codasig : String  = ""
private var nomasig: String  = ""
private var semestre: String  = ""
private var tiempo: String  = ""

@Composable
fun FormActivity(navController: NavController) {
    // A surface container using the 'background' color from the theme
    Scaffold {
        BodyForm(navController)
    }
}

@Composable
fun BodyForm(navController: NavController) {
    Column {
        Text(text = "Ingrese los datos")
        LazyColumn {
            items(form){line -> ItemForm(text = line)}
        }
        Button(onClick = {
            navController.navigate(route = AppScreens.ListActivity.route+ "/${form.last()}/Angel" )
        }) {
            Text(text = "Guardar")
        }
    }
}

@Composable
fun ItemForm(text: String){
    Row(modifier = Modifier.padding(5.dp)){
        Row (modifier = Modifier
            .padding(top = 20.dp)
            .width(180.dp)){
            Text(text = text)
        }
        Row(modifier = Modifier
            .padding(end = 15.dp)){
            TextInput()
        }
    }
}

@Composable
fun TextInput(){
    var text by remember{ mutableStateOf("")}
    TextField(value = text, onValueChange = {
            text = it
            periodo = it
        }
    )
}
