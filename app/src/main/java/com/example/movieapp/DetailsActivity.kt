package com.example.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.example.movieapp.data.MovieRepository
import com.example.movieapp.model.Movie
import com.example.movieapp.ui.screens.DetailsScreen
import com.example.movieapp.ui.theme.MovieAppTheme

/**
 * DetailsActivity - Màn hình chi tiết phim
 * Được sử dụng khi điều hướng từ bên ngoài (Intent-based).
 * Trong luồng Compose chính, điều hướng được xử lý bằng Navigation Compose.
 */
class DetailsActivity : ComponentActivity() {

    companion object {
        const val MOVIE_ID = "MOVIE_ID"
    }

    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movieId = intent.getLongExtra(MOVIE_ID, -1L)
        val movie = if (movieId != -1L) {
            MovieRepository.getMovieById(movieId)
        } else {
            null
        } ?: MovieRepository.getSeries().first()

        setContent {
            MovieAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    shape = RectangleShape
                ) {
                    DetailsScreen(
                        movie = movie,
                        onBackPressed = { finish() }
                    )
                }
            }
        }
    }
}
