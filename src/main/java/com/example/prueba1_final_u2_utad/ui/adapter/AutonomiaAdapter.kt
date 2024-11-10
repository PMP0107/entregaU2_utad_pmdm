package com.example.prueba1_final_u2_utad.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba1_final_u2_utad.databinding.ItemAutonomiaBinding
import com.example.prueba1_final_u2_utad.model.Autonomia

class AutonomiaAdapter(
    private val autonomias: List<Autonomia>,
    private val onClick: (Autonomia) -> Unit,
    private val onLongClick: (Autonomia) -> Unit
) : RecyclerView.Adapter<AutonomiaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutonomiaViewHolder {
        val binding = ItemAutonomiaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AutonomiaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AutonomiaViewHolder, position: Int) {
        holder.bind(autonomias[position], onClick, onLongClick)
    }

    override fun getItemCount(): Int = autonomias.size
}
