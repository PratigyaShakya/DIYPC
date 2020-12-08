package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.Adapter.BufferAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_buffer.*

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
                    val intent = Intent(this, ListPartsBuilder::class.java)
                    startActivity(intent)
                    true
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