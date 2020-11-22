package com.example.roomdbexample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.roomdbexample.databinding.ActivityCreateNoteBinding

class CreateNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateNoteBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_note)

        val db: AppDatabase =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "notes")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        binding.btnAdd.setOnClickListener {
            val note = Note(
                binding.noteTitle.text.toString(),
                binding.noteSubject.text.toString(),
                binding.noteDescription.text.toString()
            )
            db.notedao().insertAll(note)
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}