package com.francisgonzales.jetpackmvcpattern.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.francisgonzales.jetpackmvcpattern.model.Note

@Composable
fun NoteItem(note: Note) {
    Card(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = note.title, style = MaterialTheme.typography.titleLarge)
            Text(text = note.description, style = MaterialTheme.typography.titleSmall)
        }
    }
}

@Composable
fun NotesList(notes: List<Note>) {

    if (notes.isEmpty()) {
        Text("No notes to display")
    } else {
        Column (modifier = Modifier.padding(24.dp) ) {
            for (note in notes) {
                NoteItem(note = note)
            }
        }
    }

}
