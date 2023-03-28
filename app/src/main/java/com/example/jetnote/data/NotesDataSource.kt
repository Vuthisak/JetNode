package com.example.jetnote.data

import com.example.jetnote.model.Note

class NotesDataSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "A good day", description = "We went on a vacation"),
            Note(title = "Android Compose", description = "Working on compose"),
            Note(title = "Keep at it...", description = "Something things just happen"),
            Note(title = "A movie day", description = "Watching a move with family"),
            Note(title = "A good day", description = "We went on a vacation"),
            Note(title = "A good day", description = "We went on a vacation"),
            Note(title = "A good day", description = "We went on a vacation"),
            Note(title = "A good day", description = "We went on a vacation"),
            Note(title = "A good day", description = "We went on a vacation"),
            Note(title = "A good day", description = "We went on a vacation")
        )
    }
}