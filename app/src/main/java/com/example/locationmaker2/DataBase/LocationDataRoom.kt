package com.example.locationmaker2.DataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class LocationDataRoom {
    @PrimaryKey
    var statusLocation: String
    var streetDirection: String
    var suburbName: String

    constructor(statusLocation: String, streetDirection: String, suburbName: String){
        this.statusLocation = statusLocation
        this.streetDirection = streetDirection
        this.suburbName = suburbName
    }
}