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

class DoctorRecyclerAdapter(private var itemsList: List<String>) : RecyclerView.Adapter<DoctorRecyclerAdapter.ViewHolder>() {

    class ViewHolder (view : View) : RecyclerView.ViewHolder(view) {

        val imgIcon : ImageView
        val name : TextView
        val specialty : TextView


        init {

            imgIcon = view.findViewById(R.id.img_doctor_icon)
            name = view.findViewById(R.id.tv_doctor_name)
            specialty = view.findViewById(R.id.tv_doctor_specialty)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_doctor, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemsList[position]

        holder.imgIcon.setImageResource(R.drawable.doctor)
        holder.name.text = "Dr. Jane Misango"
        holder.specialty.text = "Cardio Surgeon"
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}