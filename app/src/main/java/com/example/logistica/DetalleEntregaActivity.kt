package com.example.logistica

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DetalleEntregaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_entrega)

        val rejectButton = findViewById<Button>(R.id.rejectButton)
        val deliverButton = findViewById<Button>(R.id.deliverButton)

        rejectButton.setOnClickListener {
            val intent = Intent(this, MotivoRechazoActivity::class.java)
            startActivity(intent)
        }

        deliverButton.setOnClickListener {
            val intent = Intent(this, ConfirmacionEntregaActivity::class.java)
            startActivity(intent)
        }
    }
}
