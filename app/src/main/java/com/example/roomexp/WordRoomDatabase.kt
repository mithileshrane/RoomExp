package com.example.roomexp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabase: RoomDatabase() {


    abstract fun wordDao(): WordDao?

    companion object{
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context?): WordRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(WordRoomDatabase::class.java) {
                    if (INSTANCE == null) { // Create database here
                        INSTANCE = Room.databaseBuilder(
                            context!!.applicationContext,
                            WordRoomDatabase::class.java, "word_database"
                        )
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .build()

                    }
                }
            }
            return INSTANCE
    }
    }

}