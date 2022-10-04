package com.example.locationmaker2.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.locationmaker2.LocationData
import com.example.locationmaker2.data.database.models.LocationsListData
import com.example.locationmaker2.databinding.ItemsCardsViewsBinding

class LocationViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val binding = ItemsCardsViewsBinding.bind(view)

    fun render(LocationDataModel: LocationData, onClickListener:(LocationData) -> Unit){
        binding.tvVisited.text = LocationDataModel.statusLocation
        binding.tvStreetName.text = LocationDataModel.streetDirection
        binding.tvSuburb.text = LocationDataModel.suburbName
        this.itemView.setOnClickListener{onClickListener(LocationDataModel)}
    }

}