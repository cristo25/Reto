package com.example.locationmaker2

import java.io.Serializable

data class LocationData (
    var statusLocation:String,
    var streetDirection:String,
    var suburbName:String
): Serializable
