package com.example.locationmaker2.DataBase

import androidx.room.Dao
import androidx.room.Query

@Dao
interface DaoLocationData {
    @Query("SELECT * FROM LocationDataRoom")
    suspend fun ObtenerDatos(): List<LocationDataRoom>

    //@Query()
}