package com.example.movieapp.data

import com.example.movieapp.model.Movie

/**
 * Repository cung cấp dữ liệu phim mẫu.
 * Trong thực tế, dữ liệu sẽ được lấy từ TMDB API.
 */
object MovieRepository {

    private val TMDB_IMAGE_BASE = "https://image.tmdb.org/t/p/w500"
    private val TMDB_BACKDROP_BASE = "https://image.tmdb.org/t/p/w1280"

    fun getMoviesByCategory(): Map<String, List<Movie>> {
        return mapOf(
            "Series" to getSeries(),
            "New Movies" to getNewMovies(),
            "Old Movies" to getOldMovies(),
            "Action" to getActionMovies(),
            "Drama" to getDramaMovies()
        )
    }

    fun getSeries(): List<Movie> = listOf(
        Movie(
            id = 1,
            title = "Sherlock",
            studio = "BBC One",
            description = "A modern update finds the famous sleuth and his doctor partner solving crime in 21st century London.",
            cardImageUrl = "$TMDB_IMAGE_BASE/7WTsnHkbA0FaG6R9twfFde0I9hl.jpg",
            backgroundImageUrl = "$TMDB_BACKDROP_BASE/aSPeBs7XKcB3xqolOlUFTrskMGS.jpg",
            category = "Series"
        ),
        Movie(
            id = 2,
            title = "Stranger Things",
            studio = "Netflix",
            description = "When a young boy disappears, his mother, a police chief, and his friends must confront terrifying supernatural forces.",
            cardImageUrl = "$TMDB_IMAGE_BASE/49WJfeN0moxb9IPfGn8AIqMGskD.jpg",
            backgroundImageUrl = "$TMDB_BACKDROP_BASE/56v2KjBlU4XaOv9rVYEQypROD7P.jpg",
            category = "Series"
        ),
        Movie(
            id = 3,
            title = "Black Mirror",
            studio = "Netflix",
            description = "An anthology series exploring a twisted, high-tech near future where humanity's greatest innovations and darkest instincts collide.",
            cardImageUrl = "$TMDB_IMAGE_BASE/7PRddO7z7mcPi21nZTCMGShAyy1.jpg",
            backgroundImageUrl = "$TMDB_BACKDROP_BASE/xP1VGBrXHPBB3xYvAumYAGDyDed.jpg",
            category = "Series"
        ),
        Movie(
            id = 4,
            title = "Dark",
            studio = "Netflix",
            description = "A family saga with a supernatural twist, set in a German town where the connections between four families are revealed.",
            cardImageUrl = "$TMDB_IMAGE_BASE/apbrbWs5M6eeR6oTM5wYm1m1PX1.jpg",
            backgroundImageUrl = "$TMDB_BACKDROP_BASE/lzWHmYdfeFiMIY4JaMmtR7GEli3.jpg",
            category = "Series"
        ),
        Movie(
            id = 5,
            title = "Breaking Bad",
            studio = "AMC",
            description = "A high school chemistry teacher turned methamphetamine manufacturer partners with a former student.",
            cardImageUrl = "$TMDB_IMAGE_BASE/ggFHVNu6YYI5L9pCfOacjizRGt.jpg",
            backgroundImageUrl = "$TMDB_BACKDROP_BASE/tsRy63Mu5cu8etL1X7ZLyf7UP1M.jpg",
            category = "Series"
        ),
        Movie(
            id = 6,
            title = "The Crown",
            studio = "Netflix",
            description = "Follows the political rivalries and romance of Queen Elizabeth II's reign and the events that shaped the second half of the 20th century.",
            cardImageUrl = "$TMDB_IMAGE_BASE/1M876KPjulVwppEpldhdc8V4o68.jpg",
            backgroundImageUrl = "$TMDB_BACKDROP_BASE/gp2D9GNXt0jyVMN5TI7FPmKHuKk.jpg",
            category = "Series"
        )
    )

    fun getNewMovies(): List<Movie> = listOf(
        Movie(
            id = 10,
            title = "Oppenheimer",
            studio = "Universal",
            description = "The story of American scientist J. Robert Oppenheimer and his role in the development of the atomic bomb.",
            cardImageUrl = "$TMDB_IMAGE_BASE/8Gxv8gSFCU0XGDykEGv7zR1n2ua.jpg",
            backgroundImageUrl = "$TMDB_BACKDROP_BASE/rLb2cwF3Pazuxaj0sRXQ037tGI1.jpg",
            category = "New Movies"
        ),
        Movie(
            id = 11,
            title = "Barbie",
            studio = "Warner Bros.",
            description = "Barbie and Ken are having the time of their lives in the colorful and seemingly perfect world of Barbie Land.",
            cardImageUrl = "$TMDB_IMAGE_BASE/iuFNMS8vlZJG6sN0lAOewmGAYER.jpg",
            backgroundImageUrl = "$TMDB_BACKDROP_BASE/ctMserH8g2SeOAnCBFRWidget0.jpg",
            category = "New Movies"
        ),
        Movie(
            id = 12,
            title = "Dune: Part Two",
            studio = "Legendary",
            description = "Paul Atreides unites with Chani and the Fremen while seeking revenge against the conspirators who destroyed his family.",
            cardImageUrl = "$TMDB_IMAGE_BASE/czembW0Rk1Ke7lCJGahbOhdCuhV.jpg",
            backgroundImageUrl = "$TMDB_BACKDROP_BASE/xOMo8BRK7PfcJv9JCnx7s5hj0PX.jpg",
            category = "New Movies"
        ),
        Movie(
            id = 13,
            title = "Poor Things",
            studio = "Searchlight",
            description = "The incredible tale about the fantastical evolution of Bella Baxter, a young woman brought back to life by a brilliant and unorthodox scientist.",
            cardImageUrl = "$TMDB_IMAGE_BASE/kCGlIMHnOm8JPXIf5S0VFg1f5ao.jpg",
            backgroundImageUrl = "$TMDB_BACKDROP_BASE/bQXAqRx2Fgc46uCVWgoPz5L5Dtr.jpg",
            category = "New Movies"
        ),
        Movie(
            id = 14,
            title = "Wonka",
            studio = "Warner Bros.",
            description = "An exploration of the fantastical origins of Willy Wonka, the world's greatest inventor, magician and chocolate-maker.",
            cardImageUrl = "$TMDB_IMAGE_BASE/qhb1qOilapbapxWQn9uh4bwi8Ud.jpg",
            backgroundImageUrl = "$TMDB_BACKDROP_BASE/9nhjGjFoiCHFaVrZLTmBQrMBNnd.jpg",
            category = "New Movies"
        )
    )

    fun getOldMovies(): List<Movie> = listOf(
        Movie(
            id = 20,
            title = "The Godfather",
            studio = "Paramount",
            description = "An organized crime dynasty's aging patriarch transfers control of his clandestine empire to his reluctant son.",
            cardImageUrl = "$TMDB_IMAGE_BASE/3bhkrj58Vtu7enYsLLeHjnNwCEe.jpg",
            backgroundImageUrl = "$TMDB_BACKDROP_BASE/tmU7GeKVjmvFYMbxwa3UFJJ2e4Q.jpg",
            category = "Old Movies"
        ),
        Movie(
            id = 21,
            title = "Schindler's List",
            studio = "Universal",
            description = "In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce.",
            cardImageUrl = "$TMDB_IMAGE_BASE/sF1U4EUQS8YHUYjNl3pMGNIQyr0.jpg",
            backgroundImageUrl = "$TMDB_BACKDROP_BASE/loRmRzQXZeqG78TqZuyvSlEQfZb.jpg",
            category = "Old Movies"
        ),
        Movie(
            id = 22,
            title = "Pulp Fiction",
            studio = "Miramax",
            description = "The lives of two mob hitmen, a boxer, a gangster and his wife intertwine in four tales of violence and redemption.",
            cardImageUrl = "$TMDB_IMAGE_BASE/d5iIlFn5s0ImszYzBPb8JPIfbXD.jpg",
            backgroundImageUrl = "$TMDB_BACKDROP_BASE/suaEOmgmg4TFTzfsHxKAS3KTJDE.jpg",
            category = "Old Movies"
        ),
        Movie(
            id = 23,
            title = "The Matrix",
            studio = "Warner Bros.",
            description = "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.",
            cardImageUrl = "$TMDB_IMAGE_BASE/f89U3ADr1oiB1s9GkdPOEpXUk5H.jpg",
            backgroundImageUrl = "$TMDB_BACKDROP_BASE/ncEsesgOJDNrTUED89hYbA117eo.jpg",
            category = "Old Movies"
        )
    )

    fun getActionMovies(): List<Movie> = listOf(
        Movie(
            id = 30,
            title = "Mad Max: Fury Road",
            studio = "Warner Bros.",
            description = "In a post-apocalyptic wasteland, Max teams up with a mysterious woman to flee a warlord.",
            cardImageUrl = "$TMDB_IMAGE_BASE/hA2ple9q4qnwxp3hKVNhroipsir.jpg",
            backgroundImageUrl = "$TMDB_BACKDROP_BASE/phszHPFBFa7tQUPZoZGEbGPKBsG.jpg",
            category = "Action"
        ),
        Movie(
            id = 31,
            title = "John Wick",
            studio = "Lionsgate",
            description = "An ex-hit-man comes out of retirement to track down the gangsters that killed his dog.",
            cardImageUrl = "$TMDB_IMAGE_BASE/fZPSd91PGQue69Ooy85GKBCyhK.jpg",
            backgroundImageUrl = "$TMDB_BACKDROP_BASE/umC04Cozevu8nn3ZTIU9CiZQSs3.jpg",
            category = "Action"
        ),
        Movie(
            id = 32,
            title = "Top Gun: Maverick",
            studio = "Paramount",
            description = "After more than thirty years of service as one of the Navy's top aviators, Pete Mitchell is where he belongs.",
            cardImageUrl = "$TMDB_IMAGE_BASE/62HCnUTziyWcpDaBO2i1DX17ljH.jpg",
            backgroundImageUrl = "$TMDB_BACKDROP_BASE/AkKdPJjnYbT8EQNM7Dn5MYMFBS.jpg",
            category = "Action"
        )
    )

    fun getDramaMovies(): List<Movie> = listOf(
        Movie(
            id = 40,
            title = "Forrest Gump",
            studio = "Paramount",
            description = "The presidencies of Kennedy and Johnson, Vietnam, Watergate, and other historical events unfold from the perspective of an Alabama man.",
            cardImageUrl = "$TMDB_IMAGE_BASE/arw2vcBveWOVZr6pxd9XTd1TdQa.jpg",
            backgroundImageUrl = "$TMDB_BACKDROP_BASE/3h1JZGDhZ8nzxdgvkxha0qBqi05.jpg",
            category = "Drama"
        ),
        Movie(
            id = 41,
            title = "The Shawshank Redemption",
            studio = "Castle Rock",
            description = "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
            cardImageUrl = "$TMDB_IMAGE_BASE/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg",
            backgroundImageUrl = "$TMDB_BACKDROP_BASE/kXfqcdQKsToO0OUXHcrrNCHDBzO.jpg",
            category = "Drama"
        )
    )

    fun getAllMovies(): List<Movie> =
        getSeries() + getNewMovies() + getOldMovies() + getActionMovies() + getDramaMovies()

    fun getMovieById(id: Long): Movie? = getAllMovies().find { it.id == id }
}
