package com.example.locationmaker2.data.database.dataBaseLocations

import android.app.Application
import androidx.room.Room
import com.example.locationmaker2.data.database.entities.LocationsListData

class LocationApp: Application() {
   /* companion object{
        lateinit var db: locationsInfoDB
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            this,
            locationsInfoDB::class.java,
            "LocationsDB"
        ).build()
    }*/
}