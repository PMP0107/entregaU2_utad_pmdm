package com.example.prueba1_final_u2_utad.provider

import com.example.prueba1_final_u2_utad.R
import com.example.prueba1_final_u2_utad.model.Autonomia

object CommunityProvider {
    val autonomias = mutableListOf<Autonomia>()

    fun getInitialData(): List<Autonomia> {
        return listOf(
            Autonomia(1, "Andalucía", R.drawable.ic_andalucia),
            Autonomia(2, "Aragón", R.drawable.ic_aragon),
            Autonomia(3, "Aturias", R.drawable.ic_asturias),
            Autonomia(4, "Baleares", R.drawable.ic_baleares),
            Autonomia(5, "Canarias", R.drawable.ic_canarias),
            Autonomia(6, "Cantabria", R.drawable.ic_cantabria),
            Autonomia(7, "Castilla y León", R.drawable.ic_castillaleon),
            Autonomia(8, "Castilla La Mancha", R.drawable.ic_castillamancha),
            Autonomia(9, "Cataluyna", R.drawable.ic_catalunya),
            Autonomia(10, "Ceuta", R.drawable.ic_ceuta),
            Autonomia(11, "Extremadura", R.drawable.ic_extremadura),
            Autonomia(12, "Galicia", R.drawable.ic_galicia),
            Autonomia(13, "La Rioja", R.drawable.ic_larioja),
            Autonomia(14, "Madrid", R.drawable.ic_madrid),
            Autonomia(15, "Melilla", R.drawable.ic_melilla),
            Autonomia(16, "Murcia", R.drawable.ic_murcia),
            Autonomia(18, "Navarra", R.drawable.ic_navarra),
            Autonomia(19, "País Vasco", R.drawable.ic_paisvasco),
            Autonomia(19, "Comunidad Valenciana", R.drawable.ic_valencia)
        )
    }

    fun reloadInitialData() {
        autonomias.clear()
        autonomias.addAll(getInitialData())
    }
}