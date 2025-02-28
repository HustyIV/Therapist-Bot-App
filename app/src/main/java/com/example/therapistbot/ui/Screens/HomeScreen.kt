package com.example.therapistbot.ui.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import java.util.Calendar

@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            ,
        contentAlignment = Alignment.Center

    ) {
        Greeting()
    }
}

@Composable
fun Greeting() {
    val greetingText = greetingMessage()

    Text(
        text = greetingText,
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold,
    )

}

fun greetingMessage():String{
    val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    return when (hour){
        in 0..5 -> "Good Night!"
        in 6..11 -> "Good Morning!"
        in 12..17 -> "Good Afternoon!"
        else -> "Good Evening!"
    }
}