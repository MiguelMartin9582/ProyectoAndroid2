package com.example.logistica

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.logistica.ui.llamarauxFragment
import com.example.logistica.ui.soporteFragment
import com.google.android.material.navigation.NavigationView

class InicioActivity : AppCompatActivity() {
    private lateinit var dlayMenu: DrawerLayout

    private lateinit var nvMenu1: NavigationView
    private lateinit var ivMenu: ImageView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)

        dlayMenu = findViewById(R.id.dlayMenu)
        nvMenu1 = findViewById(R.id.nvMenu1)
        ivMenu = findViewById(R.id.ivMenu)

        ivMenu.setOnClickListener {
            dlayMenu.open()
        }

        nvMenu1.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true // Define que se seleccione el ítem
            dlayMenu.closeDrawers() // Cierra el menú desplegable

            // Maneja las selecciones
            when (menuItem.itemId) {
                R.id.itajustes -> replaceFragment(llamarauxFragment())
                R.id.itSoporte -> replaceFragment(soporteFragment())

            }
            true
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dlayMenu)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
    private fun replaceFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.contenedorFragments, fragment)
            .commit()
    }

}