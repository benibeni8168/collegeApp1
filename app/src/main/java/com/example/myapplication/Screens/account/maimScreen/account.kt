package com.example.myapplication.Screens.account.maimScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter


    @Composable
    fun accountpic(
        profilePic: String,
        modifier: Modifier = Modifier
            .size(80.dp)
            .padding(2.dp)
            .border(width = 1.dp, color = Color(0xfff707070), shape = CircleShape),
    ) {
        Surface(
            modifier = modifier,
            shape = CircleShape
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = profilePic),
                contentDescription = "",
                modifier = Modifier.background(color = Color.Gray, shape = CircleShape),
                contentScale = ContentScale.Crop
            )
        }


    }

