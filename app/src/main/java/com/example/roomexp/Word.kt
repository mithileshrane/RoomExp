package com.example.roomexp

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
class Word (word: String){
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private var mWord: String? = null
    init {
        mWord = word
    }

    fun getWord(): String? {
        return mWord
    }
}