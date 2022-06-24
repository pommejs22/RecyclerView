package com.example.recyclerview2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val onigiri = intent.getParcelableExtra<Onigiri>("onigiri")
        if (onigiri != null) {
            val imageView = findViewById<ImageView>(R.id.sub_Image)
            val textName = findViewById<TextView>(R.id.sub_Name)
            val text = findViewById<TextView>(R.id.sub_Text)

            imageView.setImageResource(onigiri.image)
            textName.text = onigiri.name
            text.text = onigiri.text
        }

        val backBtn : Button = findViewById(R.id.backBtn)
        backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
