package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list_part_builder.*
import kotlinx.android.synthetic.main.activity_login.*

class ListPartsBuilder: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_part_builder)

        buttonMotherboard.setOnClickListener {
            val intent = Intent(this, MotherboardActivity::class.java)
            startActivity(intent)
        }
        tv_cpu.setOnClickListener  {
            val intent = Intent(this, BuilderActivity::class.java)
            startActivity(intent)
        }


    }
}