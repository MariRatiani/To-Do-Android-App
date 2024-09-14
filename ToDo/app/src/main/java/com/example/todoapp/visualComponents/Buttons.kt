package com.example.todoapp.visualComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.todoapp.database.Note


@Composable
fun DoneButton(onDoneChanged: () -> Unit, note: Note) {
    IconButton(
        onClick = { onDoneChanged() },
        modifier = Modifier
            .size(48.dp)
            .background(
                color = if (note.isDone) MaterialTheme.colorScheme.primary else Color.LightGray,
                shape = CircleShape
            )
            .padding(8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = "isDone",
            tint = if (note.isDone) Color.White else MaterialTheme.colorScheme.onSurface
        )
    }

}

@Composable
fun HeartButton(onFavoritePressed: () -> Unit, note: Note) {
    IconButton(onClick = { onFavoritePressed() }) {
        Icon(
            imageVector = if (note.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
            contentDescription = "isFavorite",
            tint = if (note.isFavorite) Color.Yellow else Color.Gray
        )
    }
}

@Composable
fun DeleteButton(onDelete: () -> Unit) {
    IconButton(onClick = { onDelete() }) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = "Delete"
        )
    }
}

