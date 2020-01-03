package com.example.roomexp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData


class WordViewModel(application: Application): AndroidViewModel(application) {

    private var mRepository: WordRepository? = null
    private var mAllWords: LiveData<List<Word>>? = null

    init {
        mRepository =  WordRepository(application)
        mAllWords = mRepository!!.getAllWords()
    }

    fun getAllWords(): LiveData<List<Word>>? {
        return mAllWords
    }

    fun insert(word: Word?) {
        mRepository!!.insert(word)
    }


}