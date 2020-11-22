package com.example.roomdbexample

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteListViewHolder(container: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(container.context).inflate
        (
        R.layout.row_note_item, container, false
    )
) {
    val noteTitle: TextView = itemView.findViewById(R.id.txtTitle)
   val noteSubject: TextView = itemView.findViewById(R.id.txtSubject)
    val noteDescription: TextView = itemView.findViewById(R.id.txtDescription)
    fun bind(note: Note) {
        noteTitle.text = note.title
        noteSubject.text = note.subject
        noteDescription.text = note.description
    }
}