package com.example.roomexp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_new_word.*


class NewWordActivity : AppCompatActivity() {

    companion object{
         val EXTRA_REPLY =
        "com.example.android.roomwordssample.REPLY"

        const val NEW_WORD_ACTIVITY_REQUEST_CODE = 1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        button_save?.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(edit_word?.getText())) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word: String = edit_word?.getText().toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }
}