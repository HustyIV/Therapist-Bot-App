package com.example.therapistbot.ui.Screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProfileScreen(
    navController: NavController
){
    rememberNavController()

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
         Icon(
             imageVector = Icons.Default.Person,
             contentDescription = "Profile",
             modifier = Modifier
                 .size(100.dp)
                 .padding(
                     top = 40.dp,
                     //bottom = 16.dp
                 )
                 //.background(Color.LightGray)


         )
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = "atembamicah@gmail.com")

        TextButton(onClick = {}) {
            Text(text = "Help and feedback")
        }
        TextButton(onClick = {}) {
            Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings")
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = "Settings")
        }
        TextButton(onClick = {}) {
            Text(text = "Sign out")
        }
    }

}
