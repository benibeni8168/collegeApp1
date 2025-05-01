package com.example.myapplication.Screens.account.seeDevelopers
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.Screens.account.editScreen.topbar
import com.example.myapplication.Screens.homescreen.button
import com.example.myapplication.Screens.homescreen.textout
import com.example.myapplication.ui.theme.lightrale


@Composable
fun seeDevops(nav: NavHostController) {
    val openUrlLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { }



    Surface(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()),color = Color.White
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(9.dp)
        ) {
            topbar(nav = nav,
                Heading = "Developers"
            )
            Spacer(modifier = Modifier.height(20.dp))
            imageShow(
                name = "Alok Pandit",
                post ="UI Designer" ,
                onClick = {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.linkedin.com/in/alokpandit03/")
                    )
                    openUrlLauncher.launch(intent)

                },
                image = R.drawable.image,
                batch = "2022-2026"
            )

            Spacer(modifier = Modifier.height(20.dp))

            imageShow(
                name = "Mannu",
                post ="Android Developer" ,
                onClick = {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.linkedin.com/in/mannu-kumar-38a280246/")
                    )
                    openUrlLauncher.launch(intent)
                },
                image = R.drawable.bhavya,
                batch = "2022-2026"
            )




        }

    }



}
@Composable
fun imageShow(name:String,
              post:String,
              onClick:()->Unit,
              image:Int,
              batch:String
) {
    Surface(modifier = Modifier
        .padding(start = 10.dp, end = 10.dp)
        .fillMaxWidth()
        .height(400.dp),
        color = Color(0xFFE9E2E2),
        shape = RoundedCornerShape(20.dp)


    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = image), contentDescription = "",
                modifier = Modifier.size(200.dp))

            textout(title = name, modifier = Modifier
                , fontStyle =MaterialTheme.typography.titleMedium)
            textout(title = batch, modifier = Modifier,
                fontStyle = MaterialTheme.typography.bodyMedium, fontFamily = FontFamily.Serif)

            textout(title = post, modifier = Modifier, fontStyle =MaterialTheme.typography.bodyMedium,
                fontFamily = lightrale)


            Spacer(modifier = Modifier.height(10.dp))
            button(text = "Connect with me") {
                onClick()
            }



        }



    }

}
