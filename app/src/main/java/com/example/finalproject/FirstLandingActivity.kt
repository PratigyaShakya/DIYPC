package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FirstLandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_landing)

        findViewById<Button>(R.id.button_id)

    }
}