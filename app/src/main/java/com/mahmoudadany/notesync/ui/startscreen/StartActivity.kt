package com.mahmoudadany.notesync.ui.startscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mahmoudadany.notesync.R
import com.mahmoudadany.notesync.ui.startscreen.Fragment.FirstFragment

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.main_frame, FirstFragment())
        transaction.commit()
    }
//    private fun selectFragment(state:Boolean){
//        if (state) {
//            Toast.makeText(baseContext,"main", Toast.LENGTH_SHORT).show()
//            fragment= MainFragment()
//            transaction.replace(R.id.main_frame, fragment as MainFragment)
//        }else{
//            Toast.makeText(baseContext,"first", Toast.LENGTH_SHORT).show()
//            fragment=FirstFragment()
//            transaction.replace(R.id.main_frame, fragment as FirstFragment)
//        }
//    }
}