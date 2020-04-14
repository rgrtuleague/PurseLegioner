package com.example.purselegioner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.purselegioner.database.MainTable

class BalanceListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<BalanceListAdapter.WordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var rows = emptyList<MainTable>() // Cached copy of words

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rowItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = rows[position]
        holder.rowItemView.text = current.MainTable
    }

    internal fun setWords(words: List<MainTable>) {
        this.rows = words
        notifyDataSetChanged()
    }

    override fun getItemCount() = rows.size
}