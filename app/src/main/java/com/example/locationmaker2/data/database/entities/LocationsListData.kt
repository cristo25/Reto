package com.example.locationmaker2.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocationsListData (@PrimaryKey(autoGenerate = true)
                        @ColumnInfo(name = "id" ) val id : Int = 0,
                              @ColumnInfo(name = "visited" ) var visited : Boolean,
                              @ColumnInfo(name = "streetName" )var streetName : String,
                              @ColumnInfo(name = "suburb" )var suburb : String,
                              @ColumnInfo(name = "latitude" ) var latitude : Float,
                              @ColumnInfo(name ="longitude") var longitude : Float)