package com.mobile.myHealth.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobile.myHealth.R

class ServicesAdapter(private var itemsList: List<String>) : RecyclerView.Adapter<ServicesAdapter.ViewHolder>() {
    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val title : TextView
        val specialtyNo : TextView
        init {
            title = view.findViewById(R.id.tv_services_title)
            specialtyNo = view.findViewById(R.id.tv_services_description)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_services, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemsList[position]

        holder.title.text = "In-Person Consultation"
        holder.specialtyNo.text = "Lorem ipsum dolor sit amet, consectetur labore  adipiscing elit, sed do eiusmod tempor dolore  \n" +
                "incididunt ut labore et dolore "
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}