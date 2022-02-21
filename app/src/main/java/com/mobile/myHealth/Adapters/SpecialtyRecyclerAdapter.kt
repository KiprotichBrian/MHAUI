package com.mobile.myHealth.Adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mobile.myHealth.R

class SpecialtyRecyclerAdapter(private var itemsList: List<String>):RecyclerView.Adapter<SpecialtyRecyclerAdapter.ViewHolder>() {
    class ViewHolder (view : View) : RecyclerView.ViewHolder(view) {

        val imgIcon : ImageView
        val title : TextView
        val specialtyNo : TextView
        val cardView : CardView


        init {

            cardView = view.findViewById(R.id.cardViewSpecialty)
            imgIcon = view.findViewById(R.id.img_specialty_icon)
            title = view.findViewById(R.id.tv_specialty_title)
            specialtyNo = view.findViewById(R.id.tv_specialty_no)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_specialty, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemsList[position]
        val mColors = arrayOf("#00cfd5", "#16c79a", "#ffa967", "#11698e")

        holder.imgIcon.setImageResource(R.drawable.cardio)
        holder.title.text = "Cardio Specialist"
        holder.specialtyNo.text = "10 Specialties"
        holder.cardView.setCardBackgroundColor(Color.parseColor(mColors[position % mColors.size]))
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}