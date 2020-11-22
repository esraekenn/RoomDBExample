package com.example.roomdbexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.roomdbexample.databinding.ActivityCreateNoteBinding
import com.example.roomdbexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val notes:List<Note>
        val db:AppDatabase= Room.databaseBuilder(this,AppDatabase::class.java,"notes")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
        notes=db.notedao().getAllNotes()
        binding.deneme.layoutManager= LinearLayoutManager(this)
       binding.deneme.adapter=NoteListAdapter(notes,this@MainActivity)
    }
}