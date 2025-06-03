package com.example.practica_04

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practica_04.databinding.ComponenteCardPlatoBinding

class DishAdapter(private var dishes: List<Dish>) : RecyclerView.Adapter<DishAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ComponenteCardPlatoBinding) : RecyclerView.ViewHolder(binding.root) {
        private var quantity = 1


        fun bind(dish: Dish) {
            binding.dishImage.setImageResource(dish.imageResId)
            binding.dishName.text = dish.name
            binding.dishPrice.text = "S/. ${dish.price}"
            binding.dishQuantity.text = quantity.toString()

            binding.btnIncrease.setOnClickListener {
                quantity++
                binding.dishQuantity.text = quantity.toString()
            }

            binding.btnDecrease.setOnClickListener {
                if (quantity > 1) quantity--
                binding.dishQuantity.text = quantity.toString()
            }
            binding.dishCheck.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    showConfirmationDialog(binding.root.context)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ComponenteCardPlatoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dishes[position])
    }

    override fun getItemCount(): Int = dishes.size

    fun updateData(newDishes: List<Dish>) {
        dishes = newDishes
        notifyDataSetChanged()
    }
    private fun showConfirmationDialog(context: Context) {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setView(R.layout.modal_check_confirm)

        val dialog = dialogBuilder.create()
        dialog.show()
    }
}
