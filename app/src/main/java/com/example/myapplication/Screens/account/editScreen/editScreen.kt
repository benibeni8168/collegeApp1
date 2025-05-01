package com.example.myapplication.Screens.account.editScreen


import com.example.myapplication.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.Screens.homescreen.textout
import com.example.savera.Screens.account.screens.accountscreens


@Composable
fun topbar(nav: NavHostController,Heading:String="Edit Profile") {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp,top= 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {


        Icon(
            painter = painterResource(id = R.drawable.back ),
            contentDescription = "",
            tint = Color(0xffFB5607),
            modifier = Modifier.clickable {
                nav.navigate(accountscreens.MainScreen.name)
            }
        )

        Spacer(modifier = Modifier.weight(1f))
        textout(
            title = Heading, modifier = Modifier,
            fontStyle = MaterialTheme.typography.titleLarge,
            color = Color(0xffFB5607)
        )
        Spacer(modifier = Modifier.weight(1f))
    }

}
