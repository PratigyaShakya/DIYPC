package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = javaClass.name
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registration_button.setOnClickListener setOnCLickListener@{
            registrationFunction()

        }

        back_to_registration.setOnClickListener{
            Log.d("MainActivity", "Trying to show login activity")
            // Launch the login activity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun registrationFunction(){
        val email = email_editText_register.text.toString()
        val password = password_editText_register.text.toString()

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Please enter your email and password", Toast.LENGTH_SHORT).show()
            return
        }

        Log.d("MainActivity", "Email is : " + email)
        Log.d("MainActivity", "Password: $password")

        // Firebase authentication, user email and password
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if (!it.isSuccessful) return@addOnCompleteListener
                Log.d("Main", "Successfully created user with uid: ${it.result?.user?.uid}")
            }
            .addOnFailureListener{
                Log.d("Main", "Failed to create user: ${it.message}")
                Toast.makeText(this, "Registration failed :  ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }
}


//Build Folder Re-Delete Fixer
class PCBuild(buildName: String){
    var name = buildName
    var cpu = null
    var mobo = null
    var ram = null
    var gpu = null
    var case = null
    var psu = null
    var finished: Boolean = false
    var compatible: Boolean = true

}