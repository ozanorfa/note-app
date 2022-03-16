package com.task.noteapp.ui.notelists

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.task.noteapp.data.NoteDatabase
import com.task.noteapp.data.note.Note
import com.task.noteapp.data.note.NoteRepository

class NoteListViewModel(application: Application) : ViewModel() {

    val allNotes : LiveData<List<Note>>
    val repository : NoteRepository

    init {
        val dao = NoteDatabase.getDatabase(application).getNotesDao()
        repository = NoteRepository(dao)
        allNotes = repository.allNotes
    }

}