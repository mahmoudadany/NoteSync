package com.mahmoudadany.notesync.data.local.Room

import androidx.room.*
import com.mahmoudadany.notesync.pojo.NoteBook
@androidx.room.Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewNote(note:NoteBook)

    @Update
    suspend fun updateNote(note: NoteBook)

    @Delete
    suspend fun deleteNote(note: NoteBook)

    @Query("select * from notebook")
    suspend fun getAllNote():List<NoteBook>
}