package com.mahmoudadany.notesync.data.local

import android.content.Context
import android.content.SharedPreferences

class Shared {

    private var sharedPreferences:SharedPreferences? =null
    private var editor=sharedPreferences?.edit()

    private constructor(context: Context) {
        sharedPreferences=context.getSharedPreferences("shard",Context.MODE_PRIVATE)
        editor=sharedPreferences?.edit()
    }

    companion object {
       private var shard: Shared? = null

        public fun getInstance(context: Context): Shared {
            if(shard ==null){
                shard = Shared(context)
            }
            return shard as Shared
        }

    }

    fun setData(state:Boolean):Boolean{
        return try {
            editor?.putBoolean("state",state)
            editor?.commit()
            true
        }catch (e:Exception){
            false
        }
    }

    fun getData(): Boolean? {
        return sharedPreferences?.getBoolean("state",false)
    }
}