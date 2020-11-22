package com.example.roomdbexample

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Query("SELECT * FROM note_table")
    fun getAllNotes(): List<Note>

    @Insert
    fun insertAll(vararg note: Note)
}