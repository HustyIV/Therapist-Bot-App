package com.example.therapistbot.ui.Screens

import android.R.id.primary
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.therapistbot.R
import com.example.therapistbot.ui.theme.LightBlue
import com.example.therapistbot.viewmodel.SignInViewModel


@Composable
fun SignInScreen (
    viewModel: SignInViewModel,
    navController: NavController,
    modifier:Modifier = Modifier
){
    val email by viewModel.email.observeAsState("")
    val password by viewModel.password.observeAsState("")
    val signInResult by viewModel.signInResult.observeAsState(null)
    val errorMessage = remember { mutableStateOf("") }

    val context = LocalContext.current

    LaunchedEffect(signInResult){
        signInResult?.getOrNull()?.let { success ->
            if (success) {
                navController.navigate("home")
            }
            }
            signInResult?.exceptionOrNull()?.let { error ->
                errorMessage.value = error.message ?: "Login failed"

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
            modifier = Modifier.padding(horizontal = 16.dp),

            )



        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            placeholder = {Text(text = "Password")},
            onValueChange = {viewModel.updatePassword(it)},



            )




        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { viewModel.login(email, password) },
            modifier = Modifier.padding(40.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = LightBlue,
                contentColor = Color.White
            )
        ){
            Text(text = "Login")

        }
        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = {},

        ) {
            Icon(imageVector = Icons.Default.Fingerprint,
                contentDescription = "Fingerprint")
            Spacer(Modifier.size(10.dp))
            Text(text = "Login with fingerprint",
                color = LightBlue)
        }


        TextButton(onClick = {navController.navigate("signup") }) {
            Text(text = "Don't have an account? Sign Up",
                color = LightBlue)
        }

}
}
