package com.francisgonzales.jetpackmvcpattern

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.francisgonzales.jetpackmvcpattern.Controller.NotesController
import com.francisgonzales.jetpackmvcpattern.model.Note
import com.francisgonzales.jetpackmvcpattern.ui.theme.JetpackMvcPatternTheme
import com.francisgonzales.jetpackmvcpattern.view.components.NotesList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackMvcPatternTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NotesScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun NotesScreen(modifier: Modifier = Modifier) {
    val notesController = remember { NotesController() }
    val notes = remember { mutableStateListOf<Note>() }

    LaunchedEffect(true) {
        notesController.fetchNotes { fetchedNotes ->
            notes.clear()
            notes.addAll(fetchedNotes)
        }

    }

    NotesList(notes = notes)
}
