package com.example.locationmaker2.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.locationmaker2.data.database.dao.Dao
import com.example.locationmaker2.data.database.models.LocationsListData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel //Check what is Hilt
class MainViewModel @Inject constructor(
    private val dao: Dao
) : ViewModel() {
    val LocationsList = MutableLiveData<List<LocationsListData>>()//check Live Data in Android documentation
    val ParamaterSearch = MutableLiveData<String>()//Remove if not needed

   fun Iniciar() { //use full english in code
        viewModelScope.launch {
             var result = withContext(Dispatchers.IO) {
                insertData()
            }
           for (location in LocationsList.value!!) { //not force values. this could CRASH!!
                Log.d("mensaje", "id ${location.id}, visited ${location.visited}, " +
                        "streetName ${location.streetName}, suburb ${location.suburb}, " +
                        "latitude ${location.latitude}, longitude ${location.longitude}")
            }
        }
    }

    private suspend fun insertData() {
        dao.insertarDatos(arrayListOf( //check te deprecated info. Replace this function by insert
            LocationsListData(0,false,"Av. de la Paz 2599",
                "Arcos Vallarta",20.6721825f,-103.3844292f),
            LocationsListData(0,false,"Calle Duque de Rivas 98",
                "Arcos Vallarta",20.672624f,-103.382664f),
            LocationsListData(0,false,"Calle Emilio Castelar 139",
                "Arcos Vallarta",20.6727471f,-103.3862101f),
            LocationsListData(0,false,"Nisuburbás Leaño 99",
                "Vallarta",20.671909f,-103.387932f),
            LocationsListData(0,false,"Joaquín Arrieta 52",
                "Vallarta",20.671327f,-103.38731f),
            LocationsListData(0,false,"Nisuburbás Puga 121",
                "Vallarta",20.670273f,-103.386141f),
            LocationsListData(0,false,"Calle Manuel López Cotilla 1289",
                "suburb Americana",20.673502f,-103.376243f),
            LocationsListData(0,false,"Calle Miguel de Cervantes Saavedra 10",
                "Ladrón de Guevara",20.675891f,-103.374837f),
            LocationsListData(0,false,"Calle Bernardo de Balbuena 151",
                "Ladrón de Guevara",20.677949f,-103.372595f),
            LocationsListData(0,false,"Manuel M. Dieguez 297",
                "Santa Teresita",20.680877f,-103.370711f),
            LocationsListData(0,false,"Calle Garibaldi 1799",
                "Ladrón de Guevara",20.681479f,-103.375689f),
            LocationsListData(0,false,"C. Ignacio Herrera y Cairo 2495",
                "Ladrón de Guevara",20.683486f,-103.379787f),
            LocationsListData(0,false,"José Bonifacio Andrada 2756",
                "Prados Providencia",20.686673f,-103.385859f),
            LocationsListData(0,false,"Turín 3049",
                "Lomas de Providencia",20.694665f,-103.387882f),
            LocationsListData(0,false,"Calle Ontario 1306",
                "Providencia 2a Secc.",20.695899f,-103.381214f)
        ))
        dao.getAll()
    }
}