package com.example.roomdbexample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 1)
abstract class DatabaseManager : RoomDatabase() {
    abstract fun notedao(): NoteDao

    companion object {
        var INSTANCE: DatabaseManager? = null

        fun getDatabaseManager(context: Context): DatabaseManager? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseManager::class.java,
                    "notes"
                ).allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }

    }
}