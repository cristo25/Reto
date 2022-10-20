package com.example.locationmaker2.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.example.locationmaker2.LocationData
import com.example.locationmaker2.R
import com.example.locationmaker2.data.database.models.LocationsListData


class LocationAdapter(
    private var dataLocationList:List<LocationData>,
    private val onClickListener:(LocationData) -> Unit
) : RecyclerView.Adapter<LocationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return LocationViewHolder(layoutInflater.inflate(R.layout.items_cards_views, parent, false))
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val item = dataLocationList[position]
        holder.itemView.setOnClickListener { onClickListener }
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = dataLocationList.size


    /*fun updaeDataFilter(dataLocationList:List<LocationData>){
        this.dataLocationList = dataLocationList
        notifyDataSetChanged()
    }*/

}
