package com.example.todoapp.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.todoapp.database.Note
import com.example.todoapp.database.NoteDatabase
import com.example.todoapp.database.Repository
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val repo: Repository
    val notes: LiveData<List<Note>>

    init {
        val dao = NoteDatabase.getDatabase(application).todoDao()
        repo = Repository(dao)
        notes=repo.getSortedNotes()
    }

    fun update(note: Note) = viewModelScope.launch {
        viewModelScope.launch {
            repo.update(note)
        }
    }

    fun add(note: Note) = viewModelScope.launch {
        viewModelScope.launch {
            repo.insert(note)
        }
    }

    fun delete(note: Note) = viewModelScope.launch {
        viewModelScope.launch {
            repo.delete(note)
        }
    }
}

class NoteViewModelFactory(private val application: Application) : ViewModelProvider.AndroidViewModelFactory(application) {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NoteViewModel(application) as T
        }
        throw IllegalArgumentException("I dont know this viewModel class")
    }
}
