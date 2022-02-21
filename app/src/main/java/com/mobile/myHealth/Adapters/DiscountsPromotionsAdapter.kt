package com.mobile.myHealth.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mobile.myHealth.R


class DiscountsPromotionsAdapter(private var itemsList: List<String>) : RecyclerView.Adapter<DiscountsPromotionsAdapter.ViewHolder>() {

    class ViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        val imgBanner : ImageView

        init {
            imgBanner = view.findViewById(R.id.img_discounts_promotions)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscountsPromotionsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_discounts_promotions, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemsList[position]

        holder.imgBanner.setImageResource(R.drawable.promos)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

}