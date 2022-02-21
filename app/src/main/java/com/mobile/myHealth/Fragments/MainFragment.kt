package com.mobile.myHealth.Fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.mobile.myHealth.Adapters.PackageRecyclerAdapter
import com.mobile.myHealth.R
import kotlinx.android.synthetic.main.recycler_packages.*

class MainFragment : Fragment() {

    private val itemsList = ArrayList<String>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val healthCenter = view.findViewById<ImageView>(R.id.icon_health_center)
        val bookAppointment = view.findViewById<ImageView>(R.id.icon_book_appointment)
        val medication = view.findViewById<ImageView>(R.id.my_medication)
        val promotions = view.findViewById<ImageView>(R.id.icon_discounts_promotions)
        val recycler = view.findViewById<RecyclerView>(R.id.recyclerPackages)

        recycler.layoutManager = LinearLayoutManager(activity)
        val adapter = PackageRecyclerAdapter(itemsList)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recycler)

        itemsList.add("Item 1")
        itemsList.add("Item 2")
        itemsList.add("Item 3")
        itemsList.add("Item 4")
        itemsList.add("Item 5")
        itemsList.add("Item 6")
        itemsList.add("Item 7")
        itemsList.add("Item 8")
        itemsList.add("Item 9")
        itemsList.add("Item 10")
        itemsList.add("Item 11")
        itemsList.add("Item 12")
        itemsList.add("Item 13")
        adapter.notifyDataSetChanged()

        onClickListeners()

        return view
    }



    private fun onClickListeners() {}

}