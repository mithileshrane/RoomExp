package com.example.roomexp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class WordListAdapter(val context: Context): RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    private var mInflater: LayoutInflater? = null
    private var mWords : List<Word>? = null  // Cached copy of words

    init {
        mInflater = LayoutInflater.from(context)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WordListAdapter.WordViewHolder {
        val itemView: View = mInflater!!.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }


    override fun getItemCount(): Int {
        return mWords?.size ?: 0
    }

    override fun onBindViewHolder(holder: WordListAdapter.WordViewHolder, position: Int) {
        if (mWords != null) {
            val current = mWords!![position]
            holder.wordItemView?.setText(current.getWord())
        } else { // Covers the case of data not being ready yet.
            holder.wordItemView?.setText("No Word")
        }
    }

    fun setWords(words: List<Word>) {
        mWords = words
        notifyDataSetChanged()
    }

    class WordViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var wordItemView: TextView? = null

        init {
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }

}