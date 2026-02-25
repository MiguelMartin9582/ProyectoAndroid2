package com.example.logistica

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PanelControlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panel_control)

        val pedidos = listOf(
            Pedido("ORD-001", "María González", "Av. Principal 123, Lima", "Paquete x2, Sobre x1", 1),
            Pedido("ORD-002", "Carlos Pérez", "Jr. Los Rosales 456, Lima", "Caja grande x1", 2),
            Pedido("ORD-003", "Ana Rodríguez", "Calle Las Flores 789, Lima", "Paquete x1, Documento x3", 3)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.pendingOrdersRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PedidosAdapter(pedidos)
    }
}
