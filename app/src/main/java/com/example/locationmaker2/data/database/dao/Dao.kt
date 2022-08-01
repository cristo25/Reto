package com.example.locationmaker2.data.database.dao


import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.locationmaker2.data.database.models.LocationsListData

@Dao
interface Dao {
    @Query("SELECT * FROM LocationsListData")
    fun getAll():LiveData<List<LocationsListData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarDatos(locaciones:List<LocationsListData>):List<Long>

    @Update
    suspend fun updater(locaciones:LocationsListData):Int

    @Delete
    suspend fun deleter(locaciones: LocationsListData):Int
}