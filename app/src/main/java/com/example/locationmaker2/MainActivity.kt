package com.example.locationmaker2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.content.Intent
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.locationmaker2.adapter.LocationAdapter
import com.example.locationmaker2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val menuItem =  menu!!.findItem(binding.svBusquedaPrincipalWidget.id)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    private fun initRecyclerView() {
        binding.rvPrincipal.layoutManager = LinearLayoutManager(this)
        binding.rvPrincipal.adapter = LocationAdapter(dataProviderLocation.dataLocationList) { info ->
            onLocationPressed(info)
        }
    }

    private fun onLocationPressed(locationData: LocationData){
        val intent = Intent(this, NavegationMap::class.java)
        intent.putExtra("location", locationData)
        startActivity(intent)
    }
}