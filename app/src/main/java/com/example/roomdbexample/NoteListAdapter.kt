package com.example.roomdbexample

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NoteListAdapter(
    val noteList: List<Note>, val context: Context
) : RecyclerView.Adapter<NoteListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteListViewHolder {
        return NoteListViewHolder(parent)
    }

    override fun onBindViewHolder(holderList: NoteListViewHolder, position: Int) {
        holderList.bind(noteList[position])
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}
