package com.example.therapistbot.ui.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.therapistbot.R
import com.example.therapistbot.viewmodel.SignUpViewModel
import androidx.compose.runtime.setValue



@Composable
fun SignUpScreen (
    viewModel: SignUpViewModel,
    navController: NavController,
    modifier:Modifier = Modifier
){
    val email by viewModel.email.observeAsState("")
    val password by viewModel.password.observeAsState("")
    val confirmPassword by viewModel.confirmPassword.observeAsState("")
    val signUpResult by viewModel.signUpResult.observeAsState(null)

    LaunchedEffect(signUpResult){
        signUpResult?.getOrNull()?.let {success ->
            if (success){
                navController.navigate("login")
            }

        }

    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Image(
            painter = painterResource(R.drawable.session),
            contentDescription = "logo",
            modifier = Modifier
                .padding(16.dp)
                .height(100.dp)

        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            placeholder = {Text(text = "Email")},
            onValueChange = {viewModel.updateEmail(it)},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),


            )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
             value = password,
        placeholder = {Text(text = "Password")},
        onValueChange = {viewModel.updatePassword(it)},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),


        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = confirmPassword,
            placeholder = {Text(text = "Confirm Password")},
            onValueChange = {viewModel.updateConfirmPassword(it)},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),


            )


        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { viewModel.signUpUser(email, password) },
            modifier = Modifier.padding(40.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ){
            Text(text = "Create account")

        }
        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = {},

            ) {
            Icon(imageVector = Icons.Default.Fingerprint,
                contentDescription = "Fingerprint")
            Spacer(Modifier.size(10.dp))
            Text(text = "Sign up with fingerprint")
        }

        TextButton(onClick = { navController.navigate("login") }) {
            Text(text = "Already have an account? Sign in",
                color = Color.Blue,)
        }

    }
}
