package com.example.practica_04

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
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


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]
        holder.button.text = category
        holder.button.setBackgroundColor(if (category == selectedCategory) Color.RED else Color.GRAY)

        holder.button.setOnClickListener {
            selectedCategory = category
            notifyDataSetChanged()
            onClick(category)
        }
    }

    override fun getItemCount() = categories.size
}

