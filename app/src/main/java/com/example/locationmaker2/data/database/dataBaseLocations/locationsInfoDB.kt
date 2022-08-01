package com.example.locationmaker2.data.database.dataBaseLocations

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.locationmaker2.data.database.dao.Dao
import com.example.locationmaker2.data.database.models.LocationsListData

@Database(
    entities = [LocationsListData::class],
    version = 1
)
abstract class locationsInfoDB:RoomDatabase() {
    abstract fun getLocationData():Dao
}