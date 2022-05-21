package com.example.lab04

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.lab04.ui.theme.Lab04Theme

@Composable
fun ListActivity(navController: NavController, nombre: String?, nombre2: String?) {

    Scaffold {
        Lab04Theme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                Column{
                    Text(text = "$nombre")
                    Text(text = "$nombre2")
                    Body()
                }
            }
        }
    }
}



@Composable
fun Body() {
    val selected = remember {
        mutableStateOf(false)
    }

    Text(text = "Hello ")
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if(selected.value) Color.Blue else Color.Yellow
        ),
        onClick = { selected.value = !selected.value }
    ) {
        Text(text = "Cambiar")
    }
}