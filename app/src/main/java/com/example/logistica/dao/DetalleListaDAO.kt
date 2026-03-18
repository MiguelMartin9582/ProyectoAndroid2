package com.example.logistica.dao

import android.content.ContentValues
import android.content.Context
import com.example.logistica.data.AppDataBaseHelper
import com.example.logistica.entity.Entregas


class DetalleListaDAO(context : Context) {
    private val dbHelper = AppDataBaseHelper(context)

    fun insertar (entrega : Entregas) : Long {
        val db = dbHelper.writableDatabase
        val valores = ContentValues().apply {
            //put("idEntrega", entrega.idEntrega)
            put("idPedido", entrega.idPedido)
            put("idUsuario", entrega.idUsuario)
            put("fechaEntrega", entrega.fechaEntrega)
            put("estado", entrega.estado)
            put("observacion", entrega.observacion)
        }
        return db.insert("Entregas", null, valores)



    }
    fun obtenerTodos(idPedido : Int) : List<Entregas> {
        val db = dbHelper.readableDatabase
        val lista = mutableListOf<Entregas>()
        val cursor = db.rawQuery(
            "SELECT * FROM Entregas WHERE idPedido = ?",
            arrayOf(idPedido.toString())
        )
        while (cursor.moveToNext()) {
            lista.add(
                Entregas(
                    cursor.getInt(cursor.getColumnIndexOrThrow("idEntrega")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("idPedido")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("idUsuario")),
                    cursor.getString(cursor.getColumnIndexOrThrow("fechaEntrega")),
                    cursor.getString(cursor.getColumnIndexOrThrow("estado")),
                    cursor.getString(cursor.getColumnIndexOrThrow("observacion"))
                )
            )


    }
    cursor.close()
    db.close()
    return lista
}
}


