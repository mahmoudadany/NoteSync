package com.mahmoudadany.notesync.ui.startscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.mahmoudadany.notesync.R
import com.mahmoudadany.notesync.data.local.Shared
import com.mahmoudadany.notesync.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val shard= Shared.getInstance(baseContext)

        val handler=Handler()
        handler.postDelayed(Runnable {
            if(shard.getData()==true){
                startActivity(Intent(baseContext, MainActivity::class.java))

            }else{
                startActivity(Intent(baseContext, StartActivity::class.java))
            }

            finish()

        },1000)

    }
}