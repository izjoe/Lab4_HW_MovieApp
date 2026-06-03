package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.ui.screens.BrowseScreen
import com.example.movieapp.ui.screens.DetailsScreen
import com.example.movieapp.viewmodel.MovieViewModel

sealed class Screen(val route: String) {
    object Browse  : Screen("browse")
    object Details : Screen("details/{movieId}") {
        fun createRoute(movieId: Long) = "details/$movieId"
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: MovieViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Browse.route
    ) {
        composable(Screen.Browse.route) {
            BrowseScreen(
                viewModel = viewModel,
                onMovieSelected = { movie ->
                    navController.navigate(Screen.Details.createRoute(movie.id))
                }
            )
        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument("movieId") { type = NavType.LongType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getLong("movieId") ?: return@composable
            val movie = viewModel.getMovieById(movieId) ?: return@composable

            DetailsScreen(
                movie = movie,
                onBackPressed = { navController.popBackStack() }
            )
        }
    }
}
