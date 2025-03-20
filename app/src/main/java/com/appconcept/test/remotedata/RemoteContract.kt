package com.appconcept.test.remotedata

import com.appconcept.test.model.Album
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RemoteContract {
    @Headers("Content-Type: application/json")
    @GET("img/shared/technical-test.json")
    suspend fun getAlbums(
       // @Query("page") page: Int,
       // @Query("size") size: Int
    ): Response<List<Album>>
}