package com.example.todoapp.database

import androidx.lifecycle.LiveData
import com.example.todoapp.dao.NoteDao

class Repository(private val noteDao: NoteDao) {

    fun getSortedNotes(): LiveData<List<Note>> {
        return noteDao.getAllNotes()
    }

    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

    suspend fun update(note: Note) {
        noteDao.update(note)
    }

    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }
}
