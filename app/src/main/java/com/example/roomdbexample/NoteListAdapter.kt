package com.example.roomdbexample

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NoteListAdapter(
    val noteEntityList: List<NoteEntity>, val context: Context,
    private val setOnClickListener: (note: NoteEntity, position: Int) -> Unit
) : RecyclerView.Adapter<NoteListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteListViewHolder {
        return NoteListViewHolder(parent)
    }

    override fun onBindViewHolder(holderList: NoteListViewHolder, position: Int) {
        holderList.bind(noteEntityList[position],setOnClickListener)
    }

    override fun getItemCount(): Int {
        return noteEntityList.size
    }
}
