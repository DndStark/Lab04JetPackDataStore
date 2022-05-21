package com.example.lab04.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lab04.FormActivity
import com.example.lab04.ListActivity


@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.FormActivity.route){
        composable(route = AppScreens.FormActivity.route){
            FormActivity(navController)
        }
        composable(route=AppScreens.ListActivity.route + "/{nombre}/{nombre2}",
            arguments = listOf(
                navArgument(name = "nombre"){ type = NavType.StringType},
                navArgument(name = "nombre2"){ type = NavType.StringType}
            )
        ){
            ListActivity(navController, it.arguments?.getString("nombre"), it.arguments?.getString("nombre2"))
        }
    }

}