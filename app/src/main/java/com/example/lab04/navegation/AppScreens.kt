package com.example.lab04.navegation

sealed class AppScreens(val route: String){
    object FormActivity: AppScreens("form_activity")
    object ListActivity: AppScreens("list_activity")
}