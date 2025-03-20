package com.appconcept.test.remotedata

import com.appconcept.test.model.Album
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val request: RemoteContract) {
    suspend fun getAlbumList(): ResultWrapper<Response<List<Album>>> {
        return safeApiCall {
            request.getAlbums()
        }
    }
}