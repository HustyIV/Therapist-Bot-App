package com.example.therapistbot.viewmodel

import android.database.CursorJoiner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class SignUpViewModel : ViewModel(){

    private val auth = FirebaseAuth.getInstance()

    //Hold user password and email
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val confirmPassword = MutableLiveData<String>()
    val signUpResult = MutableLiveData<Result<Boolean>>()


    //Update the LiveData
    fun updateEmail(newEmail : String){
        email.value = newEmail
    }

    fun updatePassword(newPassword : String){
        password.value = newPassword
    }
    fun updateConfirmPassword(newConfirmPassword : String){
        confirmPassword.value = newConfirmPassword
    }
    fun signUpUser(email: String, password: String){
        if (password != confirmPassword.value){
            signUpResult.value = Result.failure(Exception("Passwords do not match"))
            return
        }
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    signUpResult.value = Result.success(true)
                } else {
                    signUpResult.value = Result.failure(
                        task.exception ?: Exception("Sign up failed")
                    )

                }
            }
    }


}