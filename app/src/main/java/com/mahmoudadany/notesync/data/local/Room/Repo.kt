package com.mahmoudadany.notesync.data.local.Room

import com.mahmoudadany.notesync.pojo.NoteBook
import kotlinx.coroutines.*

class Repo(val db: RoomDb) {
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
    fun insert(noteBook: NoteBook) {
        scope.launch {
            db.getDao().insertNewNote(noteBook)
        }
    }

    fun update(noteBook: NoteBook) {
        scope.launch {
            db.getDao().updateNote(noteBook)
        }

        fun delete(noteBook: NoteBook) {
            scope.launch {
                db.getDao().deleteNote(noteBook)
            }
        }

        fun getAllNote(): List<NoteBook>? {
            var notes: List<NoteBook>? = null
            scope.launch {
                val result = async { db.getDao().getAllNote() }
                result.join()
                notes = result.await()
            }
            return notes
        }
    }
}