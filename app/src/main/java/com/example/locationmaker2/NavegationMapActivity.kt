package com.example.locationmaker2

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.locationmaker2.databinding.ActivityNavegationMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import android.graphics.Typeface
import android.location.Location

class NavegationMapActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMyLocationClickListener {
    private lateinit var map:GoogleMap
    private lateinit var binding: ActivityNavegationMapBinding
    companion object{
        const val REQUEST_CODE_LOCATION = 0
    }
    //VARIABLES PARA CAMBIAR FUENTE DE BOTONES
    lateinit var btnChangeFont: Button
    lateinit var btnChangeFont2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        binding = ActivityNavegationMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createFragment()
        binding.btnBackActivity.setOnClickListener{
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        //CAMBIAR FUENTE DE BOTONES
        btnChangeFont = findViewById(R.id.btnNavegar)
        btnChangeFont.typeface = Typeface.createFromAsset(assets,"fonts/robotoregular.ttf")
        btnChangeFont2 = findViewById(R.id.btnRealizarVisita)
        btnChangeFont2.typeface  = Typeface.createFromAsset(assets,"fonts/robotomedium.ttf")
    }

    private fun createFragment(){
        val mapFragment: SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map)
                as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarker()
        enableLocation()
        map.setOnMyLocationClickListener(this)
    }

    private fun createMarker(){
        val coordinates = LatLng(20.6721825,-103.3844292)
        val marker = MarkerOptions().position(coordinates).title("Primera Ubicacion")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
            /*
            marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_visited_marker))
                .anchor(0.0f,1.0f)
            */
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun isLocationPermissionIsGranted() = ContextCompat.checkSelfPermission(
        this, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

    @SuppressLint("MissingPermission")
    private fun enableLocation(){
        if (!::map.isInitialized) return
        if (isLocationPermissionIsGranted()){
            map.isMyLocationEnabled = true
        } else {
            requestLocationPermission()
        }
    }

    private fun requestLocationPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(
                this, Manifest.permission.ACCESS_FINE_LOCATION)){
            Toast.makeText(this, "Acepta permisos de localización",
                Toast.LENGTH_SHORT).show()
        } else {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_CODE_LOCATION)
        }
    }

    @SuppressLint("MissingSuperCall", "MissingPermission")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode){
            REQUEST_CODE_LOCATION -> if(grantResults.isNotEmpty() && grantResults[0]==
                PackageManager.PERMISSION_GRANTED){
                map.isMyLocationEnabled = true
            } else {
                Toast.makeText(this, "Acepta permisos de localización",
                    Toast.LENGTH_SHORT).show()
            } else -> {}
        }
    }

    @SuppressLint("MissingPermission")
    override fun onResumeFragments() {
        super.onResumeFragments()
        if (!::map.isInitialized) return
        if (!isLocationPermissionIsGranted()){
            map.isMyLocationEnabled = false
            Toast.makeText(this, "Acepta permisos de localización",
                Toast.LENGTH_SHORT).show()
        }
    }

    override fun onMyLocationClick(p0: Location) {
        Toast.makeText(this, "Estan en ${p0.latitude}, ${p0.longitude}",
            Toast.LENGTH_SHORT).show()
    }
}