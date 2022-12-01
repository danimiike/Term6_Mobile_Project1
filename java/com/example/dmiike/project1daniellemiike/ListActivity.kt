package com.example.dmiike.project1daniellemiike

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class ListActivity : AppCompatActivity() {
    private lateinit var btnFinish: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        supportActionBar?.hide()

        btnFinish = findViewById(R.id.btnFinishActivity)
        btnFinish.setOnClickListener { finish() }
    }
}