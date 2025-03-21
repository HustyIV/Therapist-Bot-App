package com.example.therapistbot.ui.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.WavingHand
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import java.util.Calendar

@Composable
fun HomeScreen(
    navController: NavHostController,
   modifier: Modifier = Modifier
){
 TopBar()

}
@Composable
fun TopBar(

) {
    val navController= rememberNavController()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(35.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Profile Icon
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "menu",
            modifier = Modifier
                .size(40.dp)
                //.clip(CircleShape)
                .background(Color.LightGray)
                .padding(8.dp)
                .clickable { navController.navigate("profile") }
        )

        // Greeting
        Column {
            Greeting()
            Spacer(modifier = Modifier.size(4.dp))

            Row {
                Text(
                    text = "Welcome back",
                    fontSize = 19.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.size(8.dp))
                Icon(
                    imageVector = Icons.Default.WavingHand,
                    contentDescription = "Profile",
                )

            }
        }

        // Notification Icon
        IconButton(onClick = { /* Handle notification click */ }) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notifications"
            )
        }
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
        in 0..5 -> "Good Night,"
        in 6..11 -> "Good Morning,"
        in 12..17 -> "Good Afternoon,"
        else -> "Good Evening,"
    }
}
@Preview
@Composable
fun TopBarPreview(){
    TopBar()
}