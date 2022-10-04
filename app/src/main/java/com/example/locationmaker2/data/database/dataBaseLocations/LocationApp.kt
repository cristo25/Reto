package com.example.locationmaker2.data.database.dataBaseLocations

import android.app.Application
import androidx.room.Room

class LocationApp: Application() {
   companion object{
        lateinit var db: locationsInfoDB //VARIABLE QUE PROVOCA EL PROBLEMA
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            this,
            locationsInfoDB::class.java,
            "LocationsDB"
        ).build()
    }
}