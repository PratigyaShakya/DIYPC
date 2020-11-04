package com.example.finalproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton.setOnClickListener {
            val email = emailText_login.text.toString()
            val password = passwordText_login.text.toString()
            Log.d("Login", "Attempting to login with email and password: $email/***")
        }
        back_to_registration.setOnClickListener {
            finish()
        }
    }
}