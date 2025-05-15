package com.example.myapplication.navigation

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.myapplication.Screens.SplashScreen.SplashScreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.savera.Screens.LoadingScreen.loadingScreen
import com.example.savera.Screens.LoginScreen.LoginScreen
import com.example.savera.Screens.MainScreen.MainScreen

@RequiresApi(Build.VERSION_CODES.O)
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
        composable(route = Screens.NewuserCheck.name) {
            MainScreen(navController)
        }

        val loadingroute = Screens.LoadingScreen.name
        composable(route = "$loadingroute/{email}/{password}",
            arguments = listOf(navArgument("email"){type  = NavType.StringType},
                navArgument("password"){type = NavType.StringType}
            )
        ){
            val  email = it.arguments?.getString("email")
            val password =  it.arguments?.getString("password")
            loadingScreen(email,password, navController = navController)
        }


    }

    }
