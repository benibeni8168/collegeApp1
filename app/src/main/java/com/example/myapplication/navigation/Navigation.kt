package com.example.myapplication.navigation

import com.example.myapplication.Screens.SplashScreen.SplashScreen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.savera.Screens.LoginScreen.LoginScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.SplashScreen.name) {



       composable(route = Screens.SplashScreen.name) {
           SplashScreen(navController)

        }

        composable(route = Screens.LoginScreen.name) {
            LoginScreen(navController)
        }

    }
}