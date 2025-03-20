package com.appconcept.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.appconcept.test.model.Album
import com.appconcept.test.ui.theme.AppconceptTestTheme
import com.appconcept.test.viewmodel.AlbumViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var albumViewModel: AlbumViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AppconceptTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AlbumListScreen(
                        viewModel = albumViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun AlbumListScreen(viewModel: AlbumViewModel, modifier: Modifier = Modifier) {
    // Combine the loading and album state for single composition
    val albums by viewModel.albums.observeAsState(emptyList())
    val loading by viewModel.loading.observeAsState(false)

    // Trigger data load when the composable first loads
    LaunchedEffect(Unit) {
        viewModel.loadMoreAlbums()
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(albums) { album ->
            AlbumItem(album = album)
        }

        item {
            if (loading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    strokeWidth = 4.dp
                )
            }
        }
    }
}

@Composable
fun AlbumItem(album: Album) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(album.thumbnailUrl)
            .addHeader("User-Agent", "AppConceptTest")
            .crossfade(true)
            .diskCachePolicy(CachePolicy.ENABLED)
            .build()
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = painter,
            contentDescription = "Album thumbnail",
            modifier = Modifier
                .size(100.dp)
                .padding(end = 8.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = album.title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
    }
}
