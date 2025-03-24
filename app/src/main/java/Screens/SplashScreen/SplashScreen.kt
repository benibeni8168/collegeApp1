package Screens.SplashScreen

import android.annotation.SuppressLint
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import kotlinx.coroutines.delay

@SuppressLint("SuspiciousIndentation")
@Composable
fun SplashScreen(navController: NavHostController) {
    // State for animation toggle
    val animationChange = remember { mutableStateOf(true) }

    // Animatable for scaling the logo
    val scale = remember { androidx.compose.animation.core.Animatable(1f) }

    // Side effect to handle animation and navigation
    LaunchedEffect(Unit) {
        // Delay for initial splash time
        delay(1000)
        // Toggle the animation state after delay
        animationChange.value = !animationChange.value

        // Animate logo scaling to 6x its size
        scale.animateTo(
            targetValue = 6f,
            animationSpec = tween(
                durationMillis = 200,
                easing = {
                    OvershootInterpolator(3f).getInterpolation(it)
                }
            )
        )

        // Delay before navigating to LoginScreen
        delay(1000) // Ensure the animation is complete before navigating
        navController.navigate("LoginScreen") {
            // Prevent going back to splash screen
            popUpTo("SplashScreen") { inclusive = true }
        }
    }

    // UI layout for the splash screen
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .padding(0.dp)
                .height(300.dp)
                .width(300.dp)
                .scale(scale.value),
            color = Color(0xFFFFD60A),
            shape = CircleShape
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (animationChange.value) {
                    Image(
                        painter = painterResource(id = R.drawable.savera_logo1_removebg_preview),
                        contentDescription = "Logo",
                        modifier = Modifier.size(200.dp)
                    )
                }
            }
        }
    }
}
