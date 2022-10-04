package com.example.locationmaker2

import java.io.Serializable

data class LocationData (
    var statusLocation:String,
    var streetDirection:String,
    var suburbName:String,
    var latitudeV:Double,
    var longitudeV:Double
): Serializable
