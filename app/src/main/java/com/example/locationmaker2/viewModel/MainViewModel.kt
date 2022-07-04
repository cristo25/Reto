package com.example.locationmaker2.viewModel

import android.location.Location
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.example.locationmaker2.data.database.dataBaseLocations.LocationApp.Companion.db
import com.example.locationmaker2.data.database.entities.LocationsListData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    val LocationsList = MutableLiveData<List<LocationsListData>>()
    val ParamaterSearch = MutableLiveData<String>()

   /* fun Iniciar(){
        viewModelScope.launch {
             LocationsList.value = withContext(Dispatchers.IO){
                db.locacionDataDao().insertarDatos(arrayListOf<LocationsListData>(
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
                db.locacionDataDao().getAll()
            }
            for (location in LocationsList.value!!) {
                Log.d("mensaje", "id ${location.id}, visited ${location.visited}, " +
                        "streetName ${location.streetName}, suburb ${location.suburb}, " +
                        "latitude ${location.latitude}, longitude ${location.longitude}")
            }
        }
    }*/
}