package com.example.todoapp.visualComponents.helperClasses

import com.example.todoapp.database.Note
import com.example.todoapp.viewModel.NoteViewModel

class NoteItemActions(private val viewModel: NoteViewModel) {
    fun onNoteChange(note: Note, newText: String) {
        val newNote = note.copy(content = newText)
        viewModel.update(newNote)
    }

    fun onFavoritePressed( note: Note) {
        val newNote = note.copy(isFavorite = !note.isFavorite)
        viewModel.update(newNote)
    }

    fun onDoneChanged( note: Note) {
        val newNote = note.copy(isDone = !note.isDone)
        viewModel.update(newNote)
    }

    fun onDelete(note: Note) {
        viewModel.delete(note)
    }
}