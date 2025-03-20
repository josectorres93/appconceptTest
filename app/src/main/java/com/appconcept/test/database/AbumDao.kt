package com.appconcept.test.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AlbumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlbums(albums: List<Album>)

    @Query("SELECT * FROM albums")
    fun getAllAlbums(): Flow<List<Album>>

    @Query("DELETE FROM albums")
    suspend fun clearAlbums()
}