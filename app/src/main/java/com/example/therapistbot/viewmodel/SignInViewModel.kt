package com.example.therapistbot.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class SignInViewModel: ViewModel() {
    private val auth = FirebaseAuth.getInstance()


    //Hold user password and email
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val signInResult = MutableLiveData<Result<Boolean>>()



    //Update the LiveData
    fun updateEmail(newEmail : String){
        email.value = newEmail
    }

    fun updatePassword(newPassword : String){
        password.value = newPassword
    }

    fun login(email:String, password:String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    signInResult.value = Result.success(true)
                } else {
                    signInResult.value = Result.failure(task.exception?: Exception("Login failed"))
                }

            }
    }



}