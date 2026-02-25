package com.example.logistica

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MotivoRechazoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motivo_rechazo)

        val cancelButton = findViewById<Button>(R.id.cancelButton)
        val confirmButton = findViewById<Button>(R.id.confirmButton)

        cancelButton.setOnClickListener {
            finish()
        }

        confirmButton.setOnClickListener {
            // Aquí iría la lógica para guardar el motivo del rechazo
            finish()
        }
    }
}
