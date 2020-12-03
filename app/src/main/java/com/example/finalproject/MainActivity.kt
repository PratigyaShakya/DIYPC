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
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

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

        select_photo.setOnClickListener {
            Log.d("Main", "Trying to show photo selector")

            val intent = Intent(Intent.ACTION_PICK)
            intent.type ="image/*"
            startActivityForResult(intent, 0)
        }
    }

    var selectedPhotoUri: Uri? = null

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==0 && resultCode == Activity.RESULT_OK&& data!= null){
            Log.d("RegisterActivity", "Photo was selected")
            selectedPhotoUri = data.data
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectedPhotoUri)
            val bitmapDrawable = BitmapDrawable(bitmap)
            select_photo.setBackgroundDrawable(bitmapDrawable)
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
                uploadImageToFirebaseStorage()
            }
            .addOnFailureListener{
                Log.d("Main", "Failed to create user: ${it.message}")
                Toast.makeText(this, "Registration failed :  ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }
    private fun uploadImageToFirebaseStorage(){
        if (selectedPhotoUri == null) return
        val filename = UUID.randomUUID().toString()
        val ref = FirebaseStorage.getInstance().getReference("/images/$filename")
        ref.putFile(selectedPhotoUri!!)
            .addOnSuccessListener {
                Log.d("registerActivity", "Successfully uploaded image")
            }

    }
}
