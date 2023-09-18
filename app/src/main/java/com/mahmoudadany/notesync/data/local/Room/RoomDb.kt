package com.mahmoudadany.notesync.data.local.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mahmoudadany.notesync.pojo.FavoriteNote
import com.mahmoudadany.notesync.pojo.NoteBook

@Database(entities = [NoteBook::class,FavoriteNote::class], version = 1)
abstract class RoomDb:RoomDatabase() {

    abstract fun getDao(): Dao

    companion object{
        @Volatile
        private var instance: RoomDb?=null
        private const val DATABASE_NAME="notedatabase"
        fun getInstance(context: Context): RoomDb {
            return instance ?: synchronized(Any()){
                 instance ?: createNewInstance(context).also{ instance =it }
            }

        }

        private fun createNewInstance(context: Context): RoomDb {
            return  Room.databaseBuilder(context.applicationContext,
                    RoomDb::class.java,
                    DATABASE_NAME
            ).build()
        }
    }

}