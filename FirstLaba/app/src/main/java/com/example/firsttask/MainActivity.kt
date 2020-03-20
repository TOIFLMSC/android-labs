package com.example.firsttask

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val thread = Thread {
            Thread.sleep(2000L);
            val intent = Intent(this, ListOfElements::class.java)
            startActivity(intent)
            finish()
        }
        thread.start()
    }
}