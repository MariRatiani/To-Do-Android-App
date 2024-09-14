package com.example.todoapp.visualComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.database.Note
import com.example.todoapp.ui.theme.ToDoAppTheme
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteCard(
    note: Note,
    onDoneChanged: () -> Unit,
    onDelete: () -> Unit,
    onContentChange: (String) -> Unit,
    onFavoritePressed: () -> Unit,
    ) {
    var job: Job? by remember { mutableStateOf(null) }
    var content by remember { mutableStateOf(note.content) }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 10.dp)
            .padding(10.dp)
            .background(Color.LightGray, shape = RoundedCornerShape(5.dp)),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier.weight(1f)
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray),
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = if (note.isDone)
                                Color.Gray
                            else Color.Black
                ),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    containerColor = Color.LightGray,
                ),

                value = content,
                onValueChange = {
                    newContent ->
                    content = newContent
                },
            )
        }

        Spacer(modifier = Modifier.width(8.dp))
        DoneButton(onDoneChanged, note)
        Spacer(modifier = Modifier.width(8.dp))
        HeartButton(onFavoritePressed, note)
        Spacer(modifier = Modifier.width(8.dp))
        DeleteButton(onDelete)
    }

    LaunchedEffect(content) {
        job?.cancel()
        job = launch {
            delay(1100L)
            onContentChange(content)
        }
    }
}
