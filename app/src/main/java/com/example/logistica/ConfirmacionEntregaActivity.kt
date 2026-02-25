package com.example.logistica

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ConfirmacionEntregaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmacion_entrega)

        val cancelButton = findViewById<Button>(R.id.cancelButton)
        val confirmButton = findViewById<Button>(R.id.confirmButton)

        cancelButton.setOnClickListener {
            finish()
        }

        confirmButton.setOnClickListener {
            // Aquí iría la lógica para guardar la foto, etc.
            finish()
        }
    }
}
