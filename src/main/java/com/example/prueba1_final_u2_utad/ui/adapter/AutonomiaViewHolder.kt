package com.example.prueba1_final_u2_utad.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.prueba1_final_u2_utad.databinding.ItemAutonomiaBinding
import com.example.prueba1_final_u2_utad.model.Autonomia

class AutonomiaViewHolder(private val binding: ItemAutonomiaBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(autonomia: Autonomia, onClick: (Autonomia) -> Unit, onLongClick: (Autonomia) -> Unit) {
        Glide.with(binding.imageViewBandera.context)
            .load(autonomia.bandera)
            .into(binding.imageViewBandera)

        binding.textViewNombre.text = autonomia.nombre

        binding.root.setOnClickListener {
            onClick(autonomia)
        }

        binding.root.setOnLongClickListener {
            onLongClick(autonomia)
            true
        }
    }
}
