package com.example.roomexp

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData


class WordRepository(application: Application) {
    private var mWordDao: WordDao? = null
    private var mAllWords: LiveData<List<Word>>? = null
    init {
        val db: WordRoomDatabase = WordRoomDatabase.getDatabase(application)!!
        mWordDao = db.wordDao()
        mAllWords = mWordDao!!.getAllWords()
    }

    fun getAllWords(): LiveData<List<Word>>? {
        return mAllWords
    }
    fun insert(word: Word?) {
        InsertAsyncTask(mWordDao!!).execute(word)
    }

    private class InsertAsyncTask internal constructor(private val mAsyncTaskDao: WordDao) :
        AsyncTask<Word?, Void?, Void?>() {

        override fun doInBackground(vararg params: Word?): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }

    }

}