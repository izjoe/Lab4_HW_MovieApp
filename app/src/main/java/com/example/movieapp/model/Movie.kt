package com.example.movieapp.model

import java.io.Serializable

data class Movie(
    val id: Long = 0L,
    val title: String = "",
    val studio: String = "",
    val description: String = "",
    val cardImageUrl: String = "",
    val backgroundImageUrl: String = "",
    val category: String = ""
) : Serializable {
    companion object {
        const val serialVersionUID = 7275661750759686531L
    }
}
