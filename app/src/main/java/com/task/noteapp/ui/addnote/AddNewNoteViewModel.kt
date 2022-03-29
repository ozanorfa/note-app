package com.task.noteapp.ui.addnote

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.task.noteapp.data.NoteDatabase
import com.task.noteapp.data.note.Note
import com.task.noteapp.data.note.NoteRepository
import com.task.noteapp.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewNoteViewModel(application: Application) : BaseViewModel() {
    var title = MutableLiveData<String>()
    var description = MutableLiveData<String>()
    var noteID = MutableLiveData<Int>()
    var type = MutableLiveData<NoteType>()
    val repository: NoteRepository

    init {
        val dao = NoteDatabase.getDatabase(application).getNotesDao()
        repository = NoteRepository(dao)
    }


    fun updateNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(note)
    }


    fun addNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }


    fun saveItem(titleVal: String, descriptionVal: String, timeStamp: String) {

        val note = Note(titleVal, descriptionVal, timeStamp)
        if (type.value!! == NoteType.NEW) {
            addNote(note)
        } else if (type.value!! == NoteType.CHANGE) {
            note.id = noteID.value!!
            updateNote(note)
        }
    }
}