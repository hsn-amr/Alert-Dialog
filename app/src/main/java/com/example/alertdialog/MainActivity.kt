package com.example.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.view.View
import android.widget.*
import android.view.Gravity

import android.widget.TextView





class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val show = findViewById<Button>(R.id.button)

        show.setOnClickListener {
            val tv = TextView(this)
            tv.text = "Text View title"
            tv.setPadding(40, 40, 40, 40)
            tv.gravity = Gravity.CENTER
            tv.textSize = 20f

            val editText = EditText(this)

            val dialog = AlertDialog.Builder(this)
                .setCustomTitle(tv)
                .setView(editText)
                .setPositiveButton("Tv", null)
                .setNegativeButton("Go"){dialogFace, which ->
                    val intent = Intent(this, Show::class.java)
                    intent.putExtra("text", editText.text.toString())
                    startActivity(intent)
                }
                .create()

            dialog.setOnShowListener {

                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                    tv.text = editText.text
                }

            }
            dialog.show()
        }
    }
}