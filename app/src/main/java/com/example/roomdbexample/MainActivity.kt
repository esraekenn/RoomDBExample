package com.example.roomdbexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdbexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var databaseManager: DatabaseManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val noteEntities: List<NoteEntity>
        databaseManager = DatabaseManager.getDatabaseManager(this)

        noteEntities = databaseManager?.notedao()!!.getAllNotes()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = NoteListAdapter(noteEntities, this@MainActivity)
        { note:NoteEntity, position:Int ->

       databaseManager?.notedao()!!.delete(note)

        }

    }
}