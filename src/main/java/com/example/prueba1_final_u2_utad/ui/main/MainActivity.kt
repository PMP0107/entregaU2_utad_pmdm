package com.example.prueba1_final_u2_utad.ui.main

import com.example.prueba1_final_u2_utad.ui.edit.EditAutonomiaActivity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prueba1_final_u2_utad.R
import com.example.prueba1_final_u2_utad.databinding.ActivityMainBinding
import com.example.prueba1_final_u2_utad.model.Autonomia
import com.example.prueba1_final_u2_utad.provider.CommunityProvider
import com.example.prueba1_final_u2_utad.ui.adapter.AutonomiaAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AutonomiaAdapter
    private lateinit var editAutonomiaLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CommunityProvider.reloadInitialData()

        setupRecyclerView()

        supportActionBar?.title = "Comunidades"

        // Configura el launcher para obtener el resultado de EditAutonomiaActivity
        editAutonomiaLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun setupRecyclerView() {
        adapter = AutonomiaAdapter(CommunityProvider.autonomias, this::onItemClick, this::onItemLongClick)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }

    private fun onItemClick(autonomia: Autonomia) {
        Toast.makeText(this, "Yo soy de ${autonomia.nombre}", Toast.LENGTH_SHORT).show()
    }

    private fun onItemLongClick(autonomia: Autonomia) {
        val opciones = arrayOf("Eliminar", "Editar")
        AlertDialog.Builder(this)
            .setTitle(autonomia.nombre)
            .setItems(opciones) { _, which ->
                when (which) {
                    0 -> eliminarAutonomia(autonomia)
                    1 -> editarAutonomia(autonomia)
                }
            }
            .show()
    }

    private fun eliminarAutonomia(autonomia: Autonomia) {
        CommunityProvider.autonomias.remove(autonomia)
        adapter.notifyDataSetChanged()
    }

    private fun editarAutonomia(autonomia: Autonomia) {
        val intent = Intent(this, EditAutonomiaActivity::class.java)
        intent.putExtra("AUTONOMIA_ID", autonomia.id)
        editAutonomiaLauncher.launch(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_recargar -> {
                CommunityProvider.reloadInitialData()
                adapter.notifyDataSetChanged()
                true
            }
            R.id.menu_limpiar -> {
                CommunityProvider.autonomias.clear()
                adapter.notifyDataSetChanged()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
