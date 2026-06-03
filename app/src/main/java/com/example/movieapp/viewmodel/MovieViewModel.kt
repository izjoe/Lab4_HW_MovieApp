package com.example.movieapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.movieapp.data.MovieRepository
import com.example.movieapp.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MovieViewModel : ViewModel() {

    private val _moviesByCategory = MutableStateFlow<Map<String, List<Movie>>>(emptyMap())
    val moviesByCategory: StateFlow<Map<String, List<Movie>>> = _moviesByCategory.asStateFlow()

    private val _selectedMovie = MutableStateFlow<Movie?>(null)
    val selectedMovie: StateFlow<Movie?> = _selectedMovie.asStateFlow()

    private val _backgroundMovie = MutableStateFlow<Movie?>(null)
    val backgroundMovie: StateFlow<Movie?> = _backgroundMovie.asStateFlow()

    init {
        loadMovies()
    }

    private fun loadMovies() {
        _moviesByCategory.value = MovieRepository.getMoviesByCategory()
        // Set default background to first series movie
        _backgroundMovie.value = MovieRepository.getSeries().firstOrNull()
    }

    fun selectMovie(movie: Movie) {
        _selectedMovie.value = movie
    }

    fun focusMovie(movie: Movie) {
        _backgroundMovie.value = movie
    }

    fun getMovieById(id: Long): Movie? = MovieRepository.getMovieById(id)
}
