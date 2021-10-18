package com.example.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Show : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        val tv = findViewById<TextView>(R.id.textView)
        val extra = intent.extras
        if(extra != null){
            tv.text = extra.getString("text")
        }
    }
}