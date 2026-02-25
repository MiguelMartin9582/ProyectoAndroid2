package com.example.logistica

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PedidosAdapter(private val pedidos: List<Pedido>) : RecyclerView.Adapter<PedidosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pedido_pendiente, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pedido = pedidos[position]
        holder.nombreCliente.text = pedido.nombreCliente
        holder.orderId.text = pedido.id
        holder.direccion.text = pedido.direccion
        holder.paqueteDescripcion.text = pedido.descripcionPaquete
        holder.prioridad.text = "Prioridad ${pedido.prioridad}"

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetalleEntregaActivity::class.java)
            // Puedes pasar datos adicionales a la actividad de detalle si es necesario
            // intent.putExtra("PEDIDO_ID", pedido.id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = pedidos.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreCliente: TextView = itemView.findViewById(R.id.nombre_cliente)
        val orderId: TextView = itemView.findViewById(R.id.order_id)
        val direccion: TextView = itemView.findViewById(R.id.direccion)
        val paqueteDescripcion: TextView = itemView.findViewById(R.id.paquete_descripcion)
        val prioridad: TextView = itemView.findViewById(R.id.prioridad)
    }
}
