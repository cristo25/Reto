package com.example.locationmaker2

import java.io.Serializable

data class LocationData (
    val statusLocation:String,
    val streetDirection:String,
    val suburbName:String
): Serializable
