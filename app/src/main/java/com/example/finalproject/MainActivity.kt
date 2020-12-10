package com.example.finalproject

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import android.os.Handler
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    private lateinit var userName: EditText
    private lateinit var userEmail: EditText
    private lateinit var userPassword: EditText
    private lateinit var auth: FirebaseAuth
    private lateinit var registerButton: Button

    private val TAG = javaClass.name
    private val db = FirebaseFirestore.getInstance()
    val email = null
    val password = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userName = findViewById(R.id.username_editText_register)
        userEmail = findViewById(R.id.email_editText_register)
        userPassword = findViewById(R.id.password_editText_register)
        registerButton = findViewById(R.id.registration_button)
        auth = FirebaseAuth.getInstance()

// For returning users to get to Buffer page instead of having to login again
        if (auth.currentUser != null) {
            val intent = Intent(this, ListPartsBuilder::class.java)
            startActivity(intent)
        }


// On click action that will let the user provide user name, email and password to register
        registerButton.setOnClickListener {
            val userName: String = username_editText_register.text.toString()
            val email: String = email_editText_register.text.toString()
            val password = password_editText_register.text.toString()

            if (userName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter your email and password.", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            } else {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            addToUserCollection()
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(
                                this,
                                "Error Message: " + task.exception!!.message.toString(),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            }
        }
    }

    // Adding user data to FireStore
    private fun addToUserCollection() {
        val user = mutableMapOf(
            "userName" to userName.text.toString(),
            "userEmail" to userEmail.text.toString()
        )
        db.collection("Users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(
                    TAG,
                    "DocumentSnapshot written with ID: ${documentReference.id}"
                )
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }
}