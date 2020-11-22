package com.example.roomdbexample

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Query("SELECT * FROM note_table")
    fun getAllNotes(): List<NoteEntity>
    @Insert
    fun insertAll(vararg noteEntity: NoteEntity)
    @Delete
    fun delete(note: NoteEntity)
}