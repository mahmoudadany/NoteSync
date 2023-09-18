package com.mahmoudadany.notesync.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "favorite")
class FavoriteNote(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var title:String,
    var body:String?=null,
    var color: Int) : Serializable
