package com.mahmoudadany.notesync.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mahmoudadany.notesync.R
import com.mahmoudadany.notesync.ui.main.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.mainactivity_frame, MainFragment())
        transaction.commit()




    }

}