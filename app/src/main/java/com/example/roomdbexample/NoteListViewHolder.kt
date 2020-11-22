package com.example.roomdbexample

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
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
    val noteDeleteButton: Button = itemView.findViewById(R.id.btnDelete)

    fun bind(
        noteEntity: NoteEntity,
        setOnClickListener: (note: NoteEntity, position: Int) -> Unit
    ) {
        noteTitle.text = noteEntity.title
        noteSubject.text = noteEntity.subject
        noteDescription.text = noteEntity.description
        noteDeleteButton.setOnClickListener {
            setOnClickListener(noteEntity, adapterPosition)
        }
    }
}