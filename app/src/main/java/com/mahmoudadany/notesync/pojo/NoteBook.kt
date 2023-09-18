package com.mahmoudadany.notesync.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "notebook")
class NoteBook(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var title:String,
    var body:String?=null,
    var favorite:Boolean=false,
    var color: Int) : Serializable