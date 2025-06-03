package com.example.practica_04

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(
    private val categories: List<String>,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var selectedCategory: String = "All"

    inner class ViewHolder(val button: Button) : RecyclerView.ViewHolder(button)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.componente_categoria, parent, false)
        return ViewHolder(view.findViewById<Button>(R.id.categoryButton))
    }
    val iconMap = mutableMapOf(
        "All" to R.drawable.ic_all,
        "Parrillas" to R.drawable.ic_parrillas,
        "Piqueos" to R.drawable.ic_piqueos,
        "Alitas" to R.drawable.ic_alitas,
        "Fríos" to R.drawable.ic_frios,
        "Calientes" to R.drawable.ic_calientes,
        "Pastas" to R.drawable.ic_pastas,
        "Jugos" to R.drawable.ic_jugos,
        "Cocktails" to R.drawable.ic_cocktails,
        "Cervezas" to R.drawable.ic_cervezas
    )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]
        holder.button.text = category.lowercase().replaceFirstChar { it.uppercaseChar() }
        holder.button.isSelected = category == selectedCategory
        holder.button.setTextColor(if (category == selectedCategory) Color.parseColor("#F5F5DC") else Color.BLACK)

        val icon = iconMap[category] ?: R.drawable.ic_all // Ícono por defecto si no se encuentra
        holder.button.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0)

        val iconResId = iconMap[category]
        if (iconResId != null) {
            val iconDrawable = ContextCompat.getDrawable(holder.button.context, iconResId)
            holder.button.setCompoundDrawablesWithIntrinsicBounds(iconDrawable, null, null, null)
        }


        holder.button.setOnClickListener {
            selectedCategory = category
            notifyDataSetChanged()
            onClick(category)
        }
    }




    override fun getItemCount() = categories.size
}

