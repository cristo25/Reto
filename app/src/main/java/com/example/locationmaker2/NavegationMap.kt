package com.example.locationmaker2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.locationmaker2.adapter.LocationAdapter
import com.example.locationmaker2.databinding.ActivityNavegationMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class NavegationMap : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map:GoogleMap
    private lateinit var binding: ActivityNavegationMapBinding
    var initActivityVar = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        binding = ActivityNavegationMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createFragment()

    }
    private fun createFragment(){
        val mapFragment: SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }



    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarker()
    }
    private fun createMarker(){
        val coordinates = LatLng(20.6721825,-103.3844292)
        val marker = MarkerOptions().position(coordinates).title("Primera Ubicacion")
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

}