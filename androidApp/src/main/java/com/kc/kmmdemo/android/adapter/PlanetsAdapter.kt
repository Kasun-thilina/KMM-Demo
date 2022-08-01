package com.kc.kmmdemo.android.adapter

import Planet
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kc.kmmdemo.android.databinding.ItemPlanetBinding

class PlanetsAdapter(var context: Context) : RecyclerView.Adapter<PlanetViewHolder>() {
    private var planets: MutableList<Planet>? = mutableListOf()
    private var selectedIndex = -1
    private var onTopicClick: ((Planet, Int) -> Unit)? = null
    private lateinit var binding: ItemPlanetBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        binding = ItemPlanetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlanetViewHolder(
            binding.root
        )
    }


    override fun getItemCount(): Int = planets?.size ?: 0


    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        planets?.get(position)?.let { book ->
            holder.bind(book, selectedIndex == position, binding, context) {
                onTopicClick?.invoke(book, position)
            }
        }
    }

    fun updatePlanets(planetsList: MutableList<Planet>) {
        planets?.addAll(planetsList)
        notifyDataSetChanged()
    }

    fun clearPlanets() {
        planets?.clear()
        notifyDataSetChanged()
    }

    fun updateSelectedPosition(index: Int) {
        val previousSelectedIndex = selectedIndex
        selectedIndex = index
//        notifyItemChanged(previousSelectedIndex)
//        notifyItemChanged(index)
        notifyDataSetChanged()
    }

    fun setTopicClickListener(onTopicClick: ((Planet, Int) -> Unit)?) {
        this.onTopicClick = onTopicClick
    }

}