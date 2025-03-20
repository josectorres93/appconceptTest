package com.appconcept.test.repository

import com.appconcept.test.database.AlbumDao
import com.appconcept.test.model.Album
import com.appconcept.test.model.toDatabaseModel
import com.appconcept.test.model.toDomainModel
import com.appconcept.test.remotedata.RemoteDataSource
import com.appconcept.test.remotedata.ResultWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AlbumRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val albumDao: AlbumDao
) {

    fun getAlbumsFromDb(): Flow<List<Album>> {
        return albumDao.getAllAlbums().map { albums ->
            albums.map { it.toDomainModel() }
        }
    }

    suspend fun getAlbuns(): List<Album>? {
        val resultWrapper = remoteDataSource.getAlbumList()

        return when (resultWrapper) {
            is ResultWrapper.Success -> {
                val albums = resultWrapper.value.body()

                if (albums != null) {
                    albumDao.insertAlbums(albums.map { it.toDatabaseModel() })
                }
                albums
            }
            is ResultWrapper.GenericError, is ResultWrapper.NetworkError -> {
                null
            }
        }
    }
}
