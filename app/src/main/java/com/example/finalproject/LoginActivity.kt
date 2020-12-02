package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton.setOnClickListener {
            val email = emailText_login.text.toString()
            val password = passwordText_login.text.toString()
            Log.d("Login", "Attempting to login with email and password: $email/***")

            // Firebase Authentication
            // more work on this to be done
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener{
                    if (!it.isSuccessful) return@addOnCompleteListener
                    Log.d("Main", "Successfully logged in with uid: ${it.result?.user?.uid}")
                }
                .addOnFailureListener{
                    Log.d("Main", "Failed to login: ${it.message}")
                }
        }
        back_to_registration.setOnClickListener {
            finish()
        }

        skipButton_Login.setOnClickListener {
            val intent = Intent(this, ListPartsBuilder::class.java)
            startActivity(intent)
        }
    }
}