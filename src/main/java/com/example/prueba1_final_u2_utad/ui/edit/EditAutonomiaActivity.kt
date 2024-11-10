package com.example.prueba1_final_u2_utad.ui.edit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba1_final_u2_utad.databinding.ActivityEditAutonomiaBinding
import com.example.prueba1_final_u2_utad.provider.CommunityProvider
import com.bumptech.glide.Glide

class EditAutonomiaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditAutonomiaBinding
    private var autonomiaId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditAutonomiaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        autonomiaId = intent.getIntExtra("AUTONOMIA_ID", -1)

        if (autonomiaId == -1) {
            Toast.makeText(this, "Error: ID de autonomía no válido", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // Buscar la autonomía en la lista
        val autonomia = CommunityProvider.autonomias.find { it.id == autonomiaId }

        if (autonomia != null) {
            binding.editTextNombre.setText(autonomia.nombre)
            Glide.with(this)
                .load(autonomia.bandera)
                .into(binding.imageViewBandera)
        } else {
            Toast.makeText(this, "Error: Autonomía no encontrada", Toast.LENGTH_SHORT).show()
            finish()
        }

        // Configurar el botón de cambiar
        binding.buttonCambiar.setOnClickListener {
            val nuevoNombre = binding.editTextNombre.text.toString()
            if (nuevoNombre.isNotBlank()) {
                autonomia?.nombre = nuevoNombre
                Toast.makeText(this, "Nombre actualizado", Toast.LENGTH_SHORT).show()
                setResult(RESULT_OK)
                finish()
            } else {
                Toast.makeText(this, "Por favor, ingresa un nombre", Toast.LENGTH_SHORT).show()
            }
        }

        // Configurar el botón de cancelar
        binding.buttonCancelar.setOnClickListener {
            finish()
        }
    }
}
