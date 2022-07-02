package com.example.locationmaker2.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.locationmaker2.data.database.entities.DataEntities

@Dao
interface DataDao {
   /* @Query("SELECT * FROM Direcciones")
    suspend fun getAllData():List<DataEntities>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll()*/
}