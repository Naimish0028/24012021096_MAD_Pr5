package com.example.a24012021096_mad_pr5

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun AppNavigation(context: Context){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login"){
        composable("login") {
            LoginScreen(context,
                navController = navController
            )
        }

        composable("register"){
            RegisterScreen(context,
                navController = navController
            )
        }
    }
}