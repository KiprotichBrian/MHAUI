package com.mobile.myHealth.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.myHealth.R
import androidx.recyclerview.widget.PagerSnapHelper

import androidx.recyclerview.widget.SnapHelper
import com.mobile.myHealth.Adapters.*


class ExploreFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerView1: RecyclerView
    private lateinit var recyclerView2: RecyclerView
    private lateinit var recyclerView3: RecyclerView
    private lateinit var recyclerView4: RecyclerView
    private lateinit var adapter: SpecialtyRecyclerAdapter
    private lateinit var adapter1: ServicesAdapter
    private lateinit var adapter2: DoctorRecyclerAdapter
    private lateinit var adapter3: PackageRecyclerAdapter
    private lateinit var adapter4: DiscountsPromotionsAdapter



    private val itemsList = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_explore, container, false)

        val specialtyIcon = view.findViewById<ImageView>(R.id.img_specialty_icon)
        val specialtyTitle = view.findViewById<ImageView>(R.id.tv_specialty_title)
        val specialtyNo = view.findViewById<ImageView>(R.id.tv_specialty_no)
        recyclerView = view.findViewById(R.id.recyclerSpecialty)
        recyclerView1 = view.findViewById(R.id.recyclerServices)
        recyclerView2 = view.findViewById(R.id.recyclerDoctor)
        recyclerView3 = view.findViewById(R.id.recyclerPackages)
        recyclerView4 = view.findViewById(R.id.recyclerDiscountsPromotions)



        specialty()
        services()
        doctors()
        packages()
        promos()

        return view
    }

    private fun specialty() {

        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = SpecialtyRecyclerAdapter(itemsList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

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
    }
    private fun services() {
        recyclerView1.layoutManager = LinearLayoutManager(activity)
        adapter1 = ServicesAdapter(itemsList)
        recyclerView1.adapter = adapter1
        recyclerView1.layoutManager = LinearLayoutManager(activity, LinearLayoutManager
            .HORIZONTAL, false)
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView1)

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
        adapter1.notifyDataSetChanged()
    }
    private fun doctors() {
        recyclerView2.layoutManager = LinearLayoutManager(activity)
        adapter2 = DoctorRecyclerAdapter(itemsList)
        recyclerView2.adapter = adapter2
        recyclerView2.layoutManager = LinearLayoutManager(activity, LinearLayoutManager
            .HORIZONTAL, false)
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView2)

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
        adapter2.notifyDataSetChanged()
    }

    private fun packages() {
        recyclerView3.layoutManager = LinearLayoutManager(activity)
        adapter3 = PackageRecyclerAdapter(itemsList)
        recyclerView3.adapter = adapter3
        recyclerView3.layoutManager = LinearLayoutManager(activity, LinearLayoutManager
            .HORIZONTAL, false)
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView3)

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
        adapter3.notifyDataSetChanged()
    }

    private fun promos() {
        recyclerView4.layoutManager = LinearLayoutManager(activity)
        adapter4 = DiscountsPromotionsAdapter(itemsList)
        recyclerView4.adapter = adapter4
        recyclerView4.layoutManager = LinearLayoutManager(activity, LinearLayoutManager
            .HORIZONTAL, false)
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView4)

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
        adapter4.notifyDataSetChanged()
    }

}