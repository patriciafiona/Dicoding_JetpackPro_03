package com.path_studio.moviecatalogue.util

import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.SeasonEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowWithSeason

/*
  Data Dummy for testing, Show all data already using TMDB API
*/
object DataDummy {

    fun generateDummyMovie(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                460465,
                "Mortal Kombat",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, " +
                        "Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of " +
                        "Outworld in a high stakes battle for the universe.",
                "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
                "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                "2021-04-07",
                7.9,
                null,
                null,
                false
            )
        )

        movies.add(
            MovieEntity(
                399566,
                "Godzilla vs. Kong",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a " +
                        "collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "/inJjDhCjfhh3RtrJWBmmDqeuSYC.jpg",
                "2021-03-24",
                8.2,
                null,
                null,
                false
            )
        )

        return movies
    }

    fun generateDummyTvShow(): List<TvShowEntity> {
        val shows = ArrayList<TvShowEntity>()

        shows.add(
            TvShowEntity(
                88396,
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, " +
                        "Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                7.9,
                "2021-03-19",
                null,
                null,
                false
            )
        )

        shows.add(
            TvShowEntity(
                71712,
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. " +
                        "The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg",
                8.6,
                "2017-09-25",
                null,
                null,
                false
            )
        )

        return shows
    }

    fun generateDummyDetailMovie(): List<MovieEntity> {
        val detailMovies = ArrayList<MovieEntity>()

        detailMovies.add(
            MovieEntity(
                460465,
                "Mortal Kombat",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, " +
                        "Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld " +
                        "in a high stakes battle for the universe.",
                "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
                "2021-04-07",
                7.9,
                arrayListOf(
                    "Fantasy",
                    "Action",
                    "Adventure",
                    "Science Fiction",
                    "Thriller"
                ).toString(),
                110,
                false
            )
        )

        detailMovies.add(
            MovieEntity(
                527774,
                "Raya and the Last Dragon",
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. " +
                        "But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. " +
                        "Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track " +
                        "down the legendary last dragon to restore the fractured land and its divided people.",
                "/7prYzufdIOy1KCTZKVWpjBFqqNr.jpg",
                "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
                "2021-03-03",
                8.3,

                arrayListOf(
                    "Animation",
                    "Adventure",
                    "Fantasy",
                    "Family",
                    "Action"
                ).toString(),
                107,
                false
            )
        )

        return detailMovies
    }

    fun generateDummyDetailTvShow(): List<TvShowEntity> {
        val detailTvShows = ArrayList<TvShowEntity>()

        detailTvShows.add(
            TvShowEntity(
                88396,
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, " +
                        "Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                7.9,
                "2021-03-19",
                arrayListOf(
                    "Sci-Fi & Fantasy",
                    "Action & Adventure",
                    "Drama",
                    "War & Politics"
                ).toString(),
                50,
                false
            )

        )

        return detailTvShows
    }

    fun generateDummyTvShowWithSeasonDetail(): List<TvShowWithSeason>{
        val seasonList = ArrayList<SeasonEntity>()

        seasonList.add(
            SeasonEntity(
                "156676",
                "88396",
                "Season 1",
                "",
                "2021-03-19",
                1,
                6,
                "/fIT6Y6O3cUX1X8qY8pZgzEvxUDQ.jpg",
                false
            )
        )

        val detailTvShowWithSeason = ArrayList<TvShowWithSeason>()

        detailTvShowWithSeason.add(
            TvShowWithSeason(
                TvShowEntity(
                    88396,
                    "The Falcon and the Winter Soldier",
                    "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, " +
                            "Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                    "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                    "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                    7.9,
                    "2021-03-19",
                    arrayListOf(
                        "Sci-Fi & Fantasy",
                        "Action & Adventure",
                        "Drama",
                        "War & Politics"
                    ).toString(),
                    50,
                    false
                ),
                seasonList
            )
        )
        return detailTvShowWithSeason
    }

}