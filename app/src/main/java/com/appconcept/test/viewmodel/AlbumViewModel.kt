package com.appconcept.test.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.appconcept.test.model.Album
import com.appconcept.test.repository.AlbumRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class AlbumViewModel @Inject constructor(private val repository: AlbumRepository) : ViewModel() {

    val albums: LiveData<List<Album>> = repository.getAlbumsFromDb().asLiveData()

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    init {
        loadMoreAlbums()
    }

    fun loadMoreAlbums() {
        viewModelScope.launch {
            _loading.value = true
            val result = repository.getAlbuns()
            _loading.value = false
        }
    }
}