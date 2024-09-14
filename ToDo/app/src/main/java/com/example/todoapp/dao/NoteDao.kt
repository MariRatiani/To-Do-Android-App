package com.example.todoapp.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todoapp.database.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes ORDER BY isDone ASC, isFavorite DESC, id DESC")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(myNote: Note)

    @Update
    suspend fun update(myNote: Note)

    @Delete
    suspend fun delete(myNote: Note)

    @Query("DELETE FROM notes")
    suspend fun clearAllNotes()
}
