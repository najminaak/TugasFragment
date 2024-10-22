package com.example.tugasfragment

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val name = sharedPreferences.getString("name", null)
        val nim = sharedPreferences.getString("nim", null)

        val textViewName: TextView = findViewById(R.id.textViewName)
        val textViewNim: TextView = findViewById(R.id.textViewNim)

        textViewNim.text = "$nim"
        textViewName.text = "$name"
    }
}
