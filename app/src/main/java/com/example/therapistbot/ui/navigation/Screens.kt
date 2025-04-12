package com.example.therapistbot.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(val route: String,val title: String,val icon: ImageVector) {
}