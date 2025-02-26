package com.example.therapistbot.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.therapistbot.ui.Screens.HomeScreen
import com.example.therapistbot.ui.Screens.SignInScreen
import com.example.therapistbot.ui.Screens.SignUpScreen
import com.example.therapistbot.viewmodel.SignInViewModel
import com.example.therapistbot.viewmodel.SignUpViewModel

@Composable
fun TherapistApp(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login"){

        composable("login") { SignInScreen(viewModel= SignInViewModel(), navController) }
        composable("signup") { SignUpScreen(viewModel= SignUpViewModel(), navController) }
        composable("home"){HomeScreen(navController)}}


    }
