package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.preferencesDataStore
import com.example.lab04.ui.theme.Lab04Theme
import android.content.Context
import com.example.lab04.navegation.AppNavigation

private val form: List<String> = listOf(
    "Periodo académico",
    "Escuela profesional",
    "Código de asignatura",
    "Nombre de asignatura",
    "Semestre",
    "Duración"
)

class MainActivity : ComponentActivity() {

    private val Context.dataStore by preferencesDataStore(DataStoreManager.PREFS_NAME)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Lab04Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab04Theme {
        AppNavigation()
    }
}