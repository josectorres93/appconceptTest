package com.appconcept.test.database

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AlbumDaoTest {

    private lateinit var albumDao: AlbumDao
    private lateinit var database: AppDatabase

    @Before
    fun setup() {
        // Initialize your Room Database and Dao
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).build()
        albumDao = database.albumDao()
    }

    @Test
    fun testInsertAlbumsDatabase() = runTest {
        // Given
        val album = Album(1, 10, "Album 1", "url1", "thumbnailUrl1")

        // When
        albumDao.insertAlbums(listOf(album))

        // Collect albums from Flow
        val albums = albumDao.getAllAlbums().first() // Using `first()` to collect the first value emitted by the Flow

        // Then
        assertEquals(1, albums.size) // Checking that the list contains 1 album
        assertEquals(album, albums[0]) // Checking that the first album is the one we inserted
    }
}
