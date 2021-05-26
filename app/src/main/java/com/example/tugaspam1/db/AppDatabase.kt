package com.example.tugaspam1.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tugaspam1.db.Note.Note
import com.example.tugaspam1.db.Note.NoteDao

@Database(entities = [Note::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {

        private const val DB_NAME = "NOTE_DB"
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room
                        .databaseBuilder(
                            context,
                            AppDatabase::class.java,
                            DB_NAME
                        )
                        .build()
                }
            }
            return instance
        }
    }
}