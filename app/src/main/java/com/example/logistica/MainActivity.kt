package com.example.logistica

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var registerLink: TextView
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerLink = findViewById(R.id.register_link)
        loginButton = findViewById(R.id.loginButton)

        registerLink.setOnClickListener {
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            val intent = Intent(this, PanelControlActivity::class.java)
            startActivity(intent)
        }
    }
}
