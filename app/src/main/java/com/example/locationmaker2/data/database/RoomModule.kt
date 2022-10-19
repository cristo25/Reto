package com.example.locationmaker2.data.database

import android.content.Context
import androidx.room.Room
import com.example.locationmaker2.data.database.dao.Dao
import com.example.locationmaker2.data.database.dataBaseLocations.locationsInfoDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//Check Hilt
@InstallIn(SingletonComponent::class)
@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): locationsInfoDB {
        return Room.databaseBuilder(
            context,
            locationsInfoDB::class.java,
            "LocationsDB"
        )
            .build()
    }

    @Singleton
    @Provides
    fun provideDao(database: locationsInfoDB): Dao {
        return database.getLocationDataDao()
    }

}