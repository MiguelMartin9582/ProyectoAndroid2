package com.example.logistica

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PanelControlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panel_control)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val pedidos = listOf(
            Pedido("ORD-001", "María González", "Av. Principal 123, Lima", "Paquete x2, Sobre x1", 1),
            Pedido("ORD-002", "Carlos Pérez", "Jr. Los Rosales 456, Lima", "Caja grande x1", 2),
            Pedido("ORD-003", "Ana Rodríguez", "Calle Las Flores 789, Lima", "Paquete x1, Documento x3", 3)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.pendingOrdersRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PedidosAdapter(pedidos)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.panel_control_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                // Redirige a la configuración de pantalla del sistema, donde se encuentra el tamaño de texto
                val intent = Intent(Settings.ACTION_DISPLAY_SETTINGS)
                startActivity(intent)
                true
            }
            R.id.action_help -> {
                // Redirige al marcador telefónico con el número especificado
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = "tel:+51984070129".toUri()
                }
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
