package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.Adapter.BufferAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_buffer.*
import kotlinx.android.synthetic.main.dialog_buffer_page.view.*

class BufferActivity: AppCompatActivity() {
    private val TAG = javaClass.name
    private val db = FirebaseFirestore.getInstance()
    private lateinit var bufferAdapter: BufferAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buffer)

        //val buildPage = intent.getSerializableExtra("Build Show Page") as? BufferModelActivity ?: return
        val query: Query = db
            .collection("Build")
            .orderBy("name")
            .limit(50)

        // query.addSnapshotListener

        val options: FirestoreRecyclerOptions<BufferModelActivity> =
            FirestoreRecyclerOptions.Builder<BufferModelActivity>()
            .setQuery(query, BufferModelActivity::class.java)
            .build()

        //showEditTextDialog()
        bufferAdapter = BufferAdapter(options, this)
        recyclerViewBuffer.adapter = bufferAdapter
        recyclerViewBuffer.layoutManager = LinearLayoutManager(this)

        // Setting selected item on the bar explicitly
        bottomNavigationBuffer.selectedItemId = R.id.newBuild

        // Adding behavior to the bottom navigation bar
        bottomNavigationBuffer.setOnNavigationItemReselectedListener {
            when(it.itemId) {
                R.id.newBuild ->{
                    // Inflate the dialog with custom view
                    val dialogBox = LayoutInflater.from(this).inflate(R.layout.dialog_buffer_page, null)
                    // Alert dialog box
                    val mBuilder = AlertDialog.Builder(this)
                        .setView(dialogBox)

                    // Show dialog
                    val mAlertDialog = mBuilder.show()
                    // Build creation custom button
                    dialogBox.dialogButtonSave.setOnClickListener {
                         mAlertDialog.dismiss()
                        val name = dialogBox.dialogBuildName.text.toString()

                        // Save the build name as a document in a Build collection
                        val user = mutableMapOf( "name" to name )
                        db.collection("Build")
                            .add(user)
                            .addOnSuccessListener { documentReference ->
                                Log.d( TAG,"DocumentSnapshot written with ID: ${documentReference.id}")
                                val intent = Intent(this, ListPartsBuilder::class.java)
                                startActivity(intent)
                                true
                             }
                            .addOnFailureListener { e ->
                            Log.w(TAG, "Error adding document", e)
                             }
                    }

                }
                //R.id.copyBuild
            }
        }

    }

    override fun onStart(){
        super.onStart()
        bufferAdapter.startListening()
    }
    override fun onStop(){
        super.onStop()
        bufferAdapter.stopListening()
    }
}