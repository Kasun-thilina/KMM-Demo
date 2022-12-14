package com.kc.kmmdemo.android.adapter

import Planet
import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kc.kmmdemo.android.R
import com.kc.kmmdemo.android.databinding.ItemPlanetBinding
import kotlinx.android.extensions.LayoutContainer

class PlanetViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {
    fun bind(
        planet: Planet,
        isSelected: Boolean,
        binding: ItemPlanetBinding,
        context: Context,
        onClick: () -> Unit
    ) {
        binding.apply {
            tvPlanetName.text = planet.name
            tvPlanetClimate.text = planet.climate
            clParent.setOnClickListener { onClick() }
//            ivPlanetImage.loadImageRound("https://picsum.photos/200?temp=${planet.name}", 10)
            if (isSelected) {
                clParent.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))
            } else {
                clParent.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhite))
            }
        }
    }
}
