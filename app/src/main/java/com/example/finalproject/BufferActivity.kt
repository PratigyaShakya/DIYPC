package com.example.finalproject

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
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


    }

    private fun showEditTextDialog() {
        addButtonBuffer.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.activity_pop_up_buffer, null)
            val editText = dialogLayout.findViewById<EditText>(R.id.popUpdialogue)

            with(builder) {
                setPositiveButton("Ok") { dialog, which ->
                    // need to setup a recycler view first, then this should create a new document in the given
                    Log.d("Buffer", "Successfully added pop up ")
                }
                setNegativeButton("Cancel") { dialog, which ->
                    Log.d("Buffer", "Successfully added pop up ")
                }
                setView(dialogLayout)
                show()
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