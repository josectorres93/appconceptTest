package com.appconcept.test.remoteData

import com.appconcept.test.model.Album
import com.appconcept.test.remotedata.RemoteContract
import com.appconcept.test.remotedata.RemoteDataSource
import com.appconcept.test.remotedata.ResultWrapper
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response
import org.mockito.kotlin.mock


@RunWith(MockitoJUnitRunner::class)
class RemoteDataSourceTest {

    private lateinit var remoteDataSource: RemoteDataSource
    private lateinit var mockRemoteContract: RemoteContract

    @Before
    fun setup() {
        mockRemoteContract = mock()
        remoteDataSource = RemoteDataSource(mockRemoteContract)
    }

    @Test
    fun `test getAlbumList returns success`() = runTest {
        // Given
        val mockAlbums = listOf(
            Album(1, 10, "Album 1", "url1", "thumbnailUrl1")
        )
        val response = Response.success(mockAlbums)
        `when`(mockRemoteContract.getAlbums()).thenReturn(response)

        // When
        val result = remoteDataSource.getAlbumList()

        // Then
        assertTrue(result is ResultWrapper.Success)
        assertEquals(mockAlbums, (result as ResultWrapper.Success).value.body())
    }

    @Test
    fun `test getAlbumList returns error`() = runTest {
        // Given
        val errorResponse: Response<List<Album>> = Response.error(500, "Internal Server Error".toResponseBody())
        `when`(mockRemoteContract.getAlbums()).thenReturn(errorResponse)

        // When
        val result = remoteDataSource.getAlbumList()

        // Then
        assertTrue(result is ResultWrapper.GenericError)
    }


}
