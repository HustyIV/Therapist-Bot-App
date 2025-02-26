package com.example.therapistbot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.therapistbot.ui.Screens.SignInScreen
import com.example.therapistbot.ui.Screens.SignUpScreen
import com.example.therapistbot.ui.navigation.TherapistApp
import com.example.therapistbot.ui.theme.TherapistBotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TherapistBotTheme {
                TherapistApp()
            }
        }
    }
}

