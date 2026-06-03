package com.example.movieapp.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieapp.model.Movie
import com.example.movieapp.ui.components.MovieRow
import com.example.movieapp.ui.theme.*
import com.example.movieapp.viewmodel.MovieViewModel

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun BrowseScreen(
    viewModel: MovieViewModel,
    onMovieSelected: (Movie) -> Unit = {}
) {
    val moviesByCategory by viewModel.moviesByCategory.collectAsStateWithLifecycle()
    val backgroundMovie by viewModel.backgroundMovie.collectAsStateWithLifecycle()

    Box(modifier = Modifier.fillMaxSize()) {

        // ── Full-screen background poster ──────────────────────────────────
        backgroundMovie?.let { movie ->
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(movie.backgroundImageUrl)
                    .crossfade(500)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Dark gradient overlay (bottom-to-top, heavier at content area)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        0.0f to Color(0xCC000000),
                        0.3f to Color(0x99000000),
                        0.7f to Color(0xBB000000),
                        1.0f to Color(0xDD000000)
                    )
                )
        )

        // ── Left blue accent bar (FastLane sidebar) ────────────────────────
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(6.dp)
                .background(TvBlue)
        )

        // ── Tab bar (top navigation) ───────────────────────────────────────
        TabBar(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 32.dp, start = 56.dp)
                .fillMaxWidth()
        )

        // ── Movie rows (vertical scroll) ───────────────────────────────────
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 120.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(moviesByCategory.entries.toList()) { (category, movies) ->
                MovieRow(
                    categoryTitle = category,
                    movies = movies,
                    onMovieClick = { movie ->
                        viewModel.selectMovie(movie)
                        onMovieSelected(movie)
                    },
                    onMovieFocus = { movie ->
                        viewModel.focusMovie(movie)
                    }
                )
            }
        }
    }
}

// ── Tab bar at the top (ErrorFragment | New Movies | Old Movies) ─────────────

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun TabBar(modifier: Modifier = Modifier) {
    val tabs = listOf("Now Playing", "New Movies", "Old Movies", "Top Rated", "My List")
    var selectedTab by remember { mutableIntStateOf(1) }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        tabs.forEachIndexed { index, title ->
            TabItem(
                title = title,
                isSelected = selectedTab == index,
                onClick = { selectedTab = index }
            )
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun TabItem(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    var isFocused by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(
                when {
                    isSelected -> TabSelected
                    isFocused  -> TabBackground.copy(alpha = 0.9f)
                    else       -> TabBackground.copy(alpha = 0.6f)
                }
            )
            .onFocusChanged { isFocused = it.isFocused }
            .focusable()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            fontSize = 15.sp,
            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
            color = if (isSelected) TextPrimary else TextSecondary
        )
    }
}
