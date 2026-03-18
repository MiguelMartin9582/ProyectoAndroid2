package com.example.logistica.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AppDataBaseHelper(context: Context) : SQLiteOpenHelper(context, "logistica.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE Roles (
                IdRol INTEGER PRIMARY KEY AUTOINCREMENT,
                Nombre TEXT NOT NULL,
                Descripcion TEXT
            );
            
            
        """.trimIndent())
        db.execSQL("""
            CREATE TABLE Usuarios (
                IdUsuario INTEGER PRIMARY KEY AUTOINCREMENT,
                Usuario TEXT NOT NULL UNIQUE,
                Contrasena TEXT NOT NULL,
                NombreCompleto TEXT,
                IdRol INTEGER,
                Activo INTEGER DEFAULT 1,
                FechaCreacion TEXT DEFAULT (datetime('now')),
                FOREIGN KEY (IdRol) REFERENCES Roles(IdRol)
            );
            
            
        """.trimIndent())
        db.execSQL("""
            CREATE TABLE Clientes (
                IdCliente INTEGER PRIMARY KEY AUTOINCREMENT,
                Nombre TEXT NOT NULL,
                Telefono TEXT,
                Email TEXT
            );
            
            
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE Direcciones (
                IdDireccion INTEGER PRIMARY KEY AUTOINCREMENT,
                IdCliente INTEGER,
                Direccion TEXT,
                Ciudad TEXT,
                Referencia TEXT,
                Latitud REAL,
                Longitud REAL,
                FOREIGN KEY (IdCliente) REFERENCES Clientes(IdCliente)
            );
            
            
        """.trimIndent())
        db.execSQL("""
            CREATE TABLE EstadosPedido (
                IdEstado INTEGER PRIMARY KEY AUTOINCREMENT,
                Nombre TEXT NOT NULL
            );
            
            
        """.trimIndent())



        db.execSQL("""
            INSERT INTO EstadosPedido (Nombre) VALUES
                ('Pendiente'),
                ('En Ruta'),
                ('Entregado'),
                ('Rechazado');
            
            
        """.trimIndent())
        db.execSQL("""
            CREATE TABLE Pedidos (
                IdPedido INTEGER PRIMARY KEY AUTOINCREMENT,
                Codigo TEXT UNIQUE,
                IdCliente INTEGER,
                IdDireccion INTEGER,
                Descripcion TEXT,
                CantidadPaquetes INTEGER,
                Prioridad INTEGER,
                IdEstado INTEGER,
                FechaRegistro TEXT DEFAULT (datetime('now')),
                FOREIGN KEY (IdCliente) REFERENCES Clientes(IdCliente),
                FOREIGN KEY (IdDireccion) REFERENCES Direcciones(IdDireccion),
                FOREIGN KEY (IdEstado) REFERENCES EstadosPedido(IdEstado)
            );
            
            
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE Rutas (
                IdRuta INTEGER PRIMARY KEY AUTOINCREMENT,
                Nombre TEXT,
                Fecha TEXT,
                IdUsuario INTEGER,
                Estado TEXT,
                FOREIGN KEY (IdUsuario) REFERENCES Usuarios(IdUsuario)
            );
            
            
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE RutaPedidos (
                IdRutaPedido INTEGER PRIMARY KEY AUTOINCREMENT,
                IdRuta INTEGER,
                IdPedido INTEGER,
                OrdenEntrega INTEGER,
                FOREIGN KEY (IdRuta) REFERENCES Rutas(IdRuta),
                FOREIGN KEY (IdPedido) REFERENCES Pedidos(IdPedido)
            );
            
            
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE Entregas (
                IdEntrega INTEGER PRIMARY KEY AUTOINCREMENT,
                IdPedido INTEGER,
                IdUsuario INTEGER,
                FechaEntrega TEXT,
                Estado TEXT,
                Observacion TEXT,
                FOREIGN KEY (IdPedido) REFERENCES Pedidos(IdPedido),
                FOREIGN KEY (IdUsuario) REFERENCES Usuarios(IdUsuario)
            );
            
            
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE Evidencias (
                IdEvidencia INTEGER PRIMARY KEY AUTOINCREMENT,
                IdEntrega INTEGER,
                UrlImagen TEXT,
                Fecha TEXT DEFAULT (datetime('now')),
                FOREIGN KEY (IdEntrega) REFERENCES Entregas(IdEntrega)
            );
            
            
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE MotivosRechazo (
                IdMotivo INTEGER PRIMARY KEY AUTOINCREMENT,
                Descripcion TEXT
            );

            
            
        """.trimIndent())

        db.execSQL("""
            INSERT INTO MotivosRechazo (Descripcion) VALUES
                ('Cliente ausente'),
                ('Dirección incorrecta'),
                ('Rechazó el paquete'),
                ('Zona insegura'),
                ('Otro motivo');
            
            
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE Rechazos (
                IdRechazo INTEGER PRIMARY KEY AUTOINCREMENT,
                IdEntrega INTEGER,
                IdMotivo INTEGER,
                Comentario TEXT,
                FOREIGN KEY (IdEntrega) REFERENCES Entregas(IdEntrega),
                FOREIGN KEY (IdMotivo) REFERENCES MotivosRechazo(IdMotivo)
            );
            
            
        """.trimIndent())



    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (oldVersion<2){
            db.execSQL("DROP TABLE IF EXISTS Roles")
            db.execSQL("DROP TABLE IF EXISTS Usuarios")
            db.execSQL("DROP TABLE IF EXISTS Clientes")

            db.execSQL("DROP TABLE IF EXISTS Direcciones")
            db.execSQL("DROP TABLE IF EXISTS EstadosPedido")
            db.execSQL("DROP TABLE IF EXISTS Pedidos")
            db.execSQL("DROP TABLE IF EXISTS Rutas")
            db.execSQL("DROP TABLE IF EXISTS RutaPedidos")
            db.execSQL("DROP TABLE IF EXISTS Entregas")
            db.execSQL("DROP TABLE IF EXISTS Evidencias")
            db.execSQL("DROP TABLE IF EXISTS MotivosRechazo")
            db.execSQL("DROP TABLE IF EXISTS Rechazos")
            onCreate(db)


        }




    }

}