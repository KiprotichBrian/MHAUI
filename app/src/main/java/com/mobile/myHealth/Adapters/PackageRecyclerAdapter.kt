package com.mobile.myHealth.Adapters

import android.opengl.ETC1.getWidth
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobile.myHealth.R


class PackageRecyclerAdapter (private var itemsList: List<String>): RecyclerView.Adapter<PackageRecyclerAdapter.ViewHolder>() {
    class ViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        val imgBackground : ImageView
        val tittle:TextView
        val description:TextView

        init {
            imgBackground = view.findViewById(R.id.img_background)
            tittle = view.findViewById(R.id.tv_title)
            description = view.findViewById(R.id.tv_description)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_medical_package, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = itemsList[position]

        holder.imgBackground.setImageResource(R.drawable.med_pack)
        holder.tittle.text = "Kids Medical Packages"
        holder.description.text = "Anything can be put here"
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }


}