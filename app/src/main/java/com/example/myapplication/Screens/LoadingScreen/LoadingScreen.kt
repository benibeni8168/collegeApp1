package com.example.savera.Screens.LoadingScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.Screens.LoginScreen.LoginScreenViewmodel
import com.example.myapplication.navigation.Screens
import com.example.myapplication.ui.theme.lightrale
import com.example.myapplication.ui.theme.ralewayfamilt
import com.example.savera.Components.alertdialogue
import com.example.myapplication.R
import kotlinx.coroutines.delay


@Composable
fun loadingScreen(
    email: String?, password: String?,
    loginScreenViewmodel: LoginScreenViewmodel = viewModel(),
    navController: NavController) {

    val error = remember {
        mutableStateOf("")
    }
    val show = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = true) {


        if (email != null) {
            if (password != null) {
                loginScreenViewmodel.signIn(
                    email = email,
                    password = password, home = {
                        navController.navigate(Screens.NewuserCheck.name)
                    },
                    anyelse = {
                        show.value = true
                        error.value = it
                        Log.d(error.value,error.value)
                    },
                    othererror = {
                        show.value = true
                        error.value = it
                        Log.d(error.value,error.value)
                    },
                    emailsent = {
                        show.value = true
                        error.value = it
                        Log.d(error.value,error.value)
                    }
                )
            }
        }
    }



    var x = 0
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screeHeight = LocalConfiguration.current.screenHeightDp.dp

    val loaddot = remember {
        mutableStateOf("")
    }

    LaunchedEffect(Unit) {


while (x<4) {
    loaddot.value = loaddot.value.plus(".")
    delay(500)
    x++
    if (x == 4) {
        loaddot.value = ""
        x = 0
    }

}
    }

    Box(modifier = Modifier) {
if (!show.value)
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White),
            color = Color.White
        ) {

            alertdialogue(detail = error.value, show = show, navController, "yes")



            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(modifier = Modifier.size(screenWidth / 2)) {
                    Image(
                        painter = painterResource(id = R.drawable.savera_logo),
                        contentDescription = ""
                    )
                }


                Spacer(modifier = Modifier.height(screenWidth / 7))
Row(modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Center) {


    Text(
        text = "Please wait" + loaddot.value,
        fontFamily = ralewayfamilt,
        fontSize = 4.5.em,
        style = MaterialTheme.typography.bodyMedium
    )
}
                Spacer(modifier = Modifier.height(screenWidth / 7))
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = "DO YOU KNOW?",
                        fontFamily = lightrale,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = "About 9 million children are out of school",
                        fontFamily = lightrale,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = "and not getting education.",
                        fontFamily = lightrale,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

            }


        }

    else
        alertdialogue(detail = error.value, show = show, navController, "yes")
    }

}