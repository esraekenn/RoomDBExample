package com.example.roomdbexample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.roomdbexample.databinding.ActivityCreateNoteBinding

class CreateNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateNoteBinding
    var databaseManager: DatabaseManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_note)

        databaseManager= DatabaseManager.getDatabaseManager(this)

        binding.btnAdd.setOnClickListener {
            val note = NoteEntity(
                binding.noteTitle.text.toString(),
                binding.noteSubject.text.toString(),
                binding.noteDescription.text.toString()
            )
            databaseManager?.notedao()!!.insertAll(note)
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}