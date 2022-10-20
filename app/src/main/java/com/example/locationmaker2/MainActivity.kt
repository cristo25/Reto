package com.example.locationmaker2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.content.Intent
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.locationmaker2.adapter.LocationAdapter
import com.example.locationmaker2.data.database.models.LocationsListData
import com.example.locationmaker2.databinding.ActivityMainBinding
import com.example.locationmaker2.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint //Check what is Hilt
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
   /* private var dataMutableList: MutableList<LocationData> =
        dataProviderLocation.dataLocationList.toMutableList()
    private lateinit var adapterFilter:LocationAdapter*/
    private val viewModel : MainViewModel by viewModels() //Check why is working
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*binding.edtSearch.addTextChangedListener { userFilterText ->
         val dataFilterItems =   dataMutableList.filter { dataDirection ->
             dataDirection.streetDirection.contains(userFilterText.toString(), ignoreCase = true) }
            adapterFilter.updaeDataFilter(dataFilterItems)
        }*/



        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.start()
            }
        }

        initRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
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
        val intent = Intent(this, NavegationMapActivity::class.java)
        intent.putExtra("location", locationData)
        startActivity(intent)
    }


}