package com.appconcept.test.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.appconcept.test.repository.AlbumRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

@OptIn(ExperimentalCoroutinesApi::class)
class AlbumViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule() // Ensures LiveData works correctly in tests.

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule() // Initializes Mockito

    @Mock
    private lateinit var repository: AlbumRepository

    private lateinit var albumViewModel: AlbumViewModel

    // Set up a TestCoroutineDispatcher for testing coroutines
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        // Set the Main dispatcher to TestCoroutineDispatcher
        Dispatchers.setMain(testDispatcher)

        // Mock the repository's behavior to return an empty Flow of albums
        `when`(repository.getAlbumsFromDb()).thenReturn(flowOf(emptyList()))

        // Initialize the ViewModel with the mock repository
        albumViewModel = AlbumViewModel(repository)
    }

    @Test
    fun testLoadMoreAlbums() = runTest {
        // Mock repository behavior for API calls
        `when`(repository.getAlbuns()).thenReturn(emptyList())

        // ViewModel's init block will call loadMoreAlbums() once
        // Call loadMoreAlbums() again manually to simulate multiple calls
        albumViewModel.loadMoreAlbums()

        // Verify repository.getAlbuns() was called exactly 2 times (1 from init, 1 from manual call)
        verify(repository, times(2)).getAlbuns()
    }
}
