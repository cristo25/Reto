package com.example.locationmaker2.data.database.dao

import androidx.room.*
import com.example.locationmaker2.data.database.entities.LocationsListData

@Dao
interface DataDao {
    @Query("SELECT * FROM LocationsListData")
    suspend fun getAll():List<LocationsListData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarDatos(locaciones:List<LocationsListData>)

    @Update
    suspend fun updater(locaciones:LocationsListData):Int

    @Delete
    suspend fun deleter(locaciones: LocationsListData):Int
}