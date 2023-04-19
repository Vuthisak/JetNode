package com.example.jetnote.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnote.data.NotesDataSource
import com.example.jetnote.model.Note
import com.example.jetnote.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged()
                .collect {
                    if (it.isEmpty()) {
                        Log.d("@@@", "Empty List")
                    } else {
                        _noteList.value = it
                    }
                }
        }
    }

    suspend fun addNode(note: Note) = viewModelScope.launch {
        repository.addNote(note)
    }

    suspend fun updateNote(note: Note) = viewModelScope.launch {
        repository.updateNote(note)
    }

    suspend fun deleteNote(note: Note) = viewModelScope.launch {
        repository.deleteNote(note)
    }

}
