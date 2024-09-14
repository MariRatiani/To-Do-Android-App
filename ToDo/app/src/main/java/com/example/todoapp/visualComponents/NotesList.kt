package com.example.todoapp.visualComponents

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.todoapp.database.Note
import androidx.compose.ui.Modifier
import com.example.todoapp.visualComponents.helperClasses.NoteItemActions

@Composable
fun NotesList(notes:  List<Note>, padding: PaddingValues, noteActions: NoteItemActions) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = padding,
        ) {
        items(notes, key = { it.id }) { note ->
            NoteCard(
                note = note,
                onContentChange = { newText ->
                        noteActions.onNoteChange(note, newText)
                },
                onFavoritePressed = {
                    noteActions.onFavoritePressed(note)
                },
                onDoneChanged = {
                    noteActions.onDoneChanged(note)
                },
                onDelete = {
                    noteActions.onDelete(note)
                }
            )
        }
    }
}

