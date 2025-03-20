package com.appconcept.test.repository


import com.appconcept.test.database.AlbumDao
import com.appconcept.test.model.Album
import com.appconcept.test.remotedata.RemoteDataSource
import com.appconcept.test.remotedata.ResultWrapper
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import retrofit2.Response


@OptIn(ExperimentalCoroutinesApi::class)
class AlbumRepositoryTest {

    @Mock
    private lateinit var remoteDataSource: RemoteDataSource

    @Mock
    private lateinit var albumDao: AlbumDao

    private lateinit var albumRepository: AlbumRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        albumRepository = AlbumRepository(remoteDataSource, albumDao)
    }

    @Test
    fun `test getAlbumsFromDb returns albums from database`() = runTest {
        // Given
        val mockDbAlbums = listOf(
            com.appconcept.test.database.Album(1, 10, "Album 1", "url1", "thumbnailUrl1"),
            com.appconcept.test.database.Album(2, 20, "Album 2", "url2", "thumbnailUrl2")
        )
        `when`(albumDao.getAllAlbums()).thenReturn(flowOf(mockDbAlbums))

        // When
        val result = albumRepository.getAlbumsFromDb()

        // Then
        result.collect { albums ->
            assertEquals(2, albums.size)
            assertEquals("Album 1", albums[0].title)
            assertEquals("Album 2", albums[1].title)
            assertEquals(10, albums[0].albumId)
            assertEquals("thumbnailUrl1", albums[0].thumbnailUrl)
        }
    }

    @Test
    fun `test getAlbuns success returns albums and saves to database`() = runTest {
        // Given
        val mockApiAlbums = listOf(
            Album(1, 10, "Album 1", "url1", "thumbnailUrl1") // id=1, albumId=10
        )
        val response = Response.success(mockApiAlbums)  // Retrofit Response<List<Album>>
        val resultWrapper = ResultWrapper.Success(response)

        `when`(remoteDataSource.getAlbumList()).thenReturn(resultWrapper)

        // When
        val result = albumRepository.getAlbuns()

        // Debugging: print the result to verify the values
        println(result)

        // Then
        assertEquals(1, result?.size) // Ensure there's 1 album
        assertEquals("Album 1", result?.get(0)?.title) // Ensure the title is correct
        assertEquals(10, result?.get(0)?.id) // Ensure albumId is correct
        assertEquals("thumbnailUrl1", result?.get(0)?.thumbnailUrl) // Ensure thumbnailUrl is correct
        verify(albumDao, times(1)).insertAlbums(anyList())  // Ensure albums were inserted into the DB
    }

    @Test
    fun `test getAlbuns returns null on network error`() = runTest {
        // Given
        `when`(remoteDataSource.getAlbumList()).thenReturn(ResultWrapper.NetworkError)

        // When
        val result = albumRepository.getAlbuns()

        // Then
        assertNull(result)
        verify(albumDao, never()).insertAlbums(anyList())  // Ensure albums were not inserted into the DB
    }

    @Test
    fun `test getAlbuns returns null on generic error`() = runTest {
        // Given
        `when`(remoteDataSource.getAlbumList()).thenReturn(ResultWrapper.GenericError(404, "Not Found"))

        // When
        val result = albumRepository.getAlbuns()

        // Then
        assertNull(result)
        verify(albumDao, never()).insertAlbums(anyList())  // Ensure albums were not inserted into the DB
    }
}