package com.example.todoapp.visualComponents

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState
import com.example.todoapp.visualComponents.helperClasses.NoteItemActions
import com.example.todoapp.database.Note
import com.example.todoapp.ui.theme.ToDoAppTheme
import com.example.todoapp.viewModel.NoteViewModel
import com.example.todoapp.viewModel.NoteViewModelFactory

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesApp() {
    val ctx = LocalContext.current
    val myViewModel: NoteViewModel = viewModel(factory = NoteViewModelFactory(ctx.applicationContext as Application))
    val notes by myViewModel.notes.observeAsState(initial = emptyList())
    val noteActions = NoteItemActions(myViewModel)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My To Do:") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    myViewModel.add(Note(content = ""))},
                modifier = Modifier.padding(20.dp)
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "new note")
            }
        },

    ) { padding ->
        NotesList(notes = notes, padding = padding, noteActions = noteActions)
    }
}