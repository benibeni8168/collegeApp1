package navigation

import Screens.LoginScreen.LoginScreen
import Screens.SplashScreen.SplashScreen
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

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