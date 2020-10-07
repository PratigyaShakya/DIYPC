package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

@Suppress("DEPRECATION")
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Splash Code taken from https://www.youtube.com/watch?v=Q0gRqbtFLcw
        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this@HomeActivity, MainActivity::class.java)
        }, 3000)

    }
}