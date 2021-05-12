package com.path_studio.moviecatalogue.util

import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.SeasonEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowWithSeason
import com.path_studio.moviecatalogue.data.source.remote.response.*

/*
  Data Dummy for testing, Show all data already using TMDB API
*/
object DataDummy {

    fun generateDummyMovieResponse(): List<ResultsItemMovie> {
        val movieResponse = ArrayList<ResultsItemMovie>()

        movieResponse.add(ResultsItemMovie(
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, " +
                    "seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            "en",
            "Mortal Kombat",
            false,
            "Mortal Kombat",
            arrayListOf(
                14,
                28,
                12,
                878,
                53
            ),
            "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
            "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
            "2021-04-07",
            6382.461,
            7.8,
            460465,
            false,
            2004
        )
        )

        movieResponse.add(ResultsItemMovie(
            "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see " +
                    "the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
            "en",
            "Godzilla vs. Kong",
            false,
            "Godzilla vs. Kong",
            arrayListOf(
                878,
                28,
                18
            ),
            "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
            "/inJjDhCjfhh3RtrJWBmmDqeuSYC.jpg",
            "2021-03-24",
            3280.437,
            8.2,
            399566,
            false,
            5218
        )
        )

        movieResponse.add(ResultsItemMovie(
            "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, " +
                    "Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
            "en",
            "Nobody",
            false,
            "Nobody",
            arrayListOf(
                28,
                53,
                80
            ),
            "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
            "/6zbKgwgaaCyyBXE4Sun4oWQfQmi.jpg",
            "2021-03-26",
            2846.371,
            8.5,
            615457,
            false,
            1104
        )
        )

        movieResponse.add(ResultsItemMovie(
            "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, " +
                    "a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, " +
                    "Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
            "ja",
            "劇場版「鬼滅の刃」無限列車編",
            false,
            "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train",
            arrayListOf(
                16,
                28,
                12,
                14,
                18
            ),
            "/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
            "/3FVe3OAdgz060JaxIAaUl5lo6cx.jpg",
            "2020-10-16",
            2299.982,
            8.3,
            635302,
            false,
            790
        )
        )

        movieResponse.add(ResultsItemMovie(
            "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, " +
                    "is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far " +
                    "flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small " +
                    "New England town to investigate. When terrifying events begin to happen all around, he starts to " +
                    "question if these phenomena are the works of the Virgin Mary or something much more sinister.",
            "en",
            "The Unholy",
            false,
            "The Unholy",
            arrayListOf(
                27
            ),
            "/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
            "/zDq2pwPyt4xwSFHKUoNN2LohDWj.jpg",
            "2021-03-31",
            2054.733,
            5.7,
            632357,
            false,
            66
        )
        )

        return movieResponse

    }

    fun generateDummyDetailMovieResponse(): List<DetailMovieResponse> {
        val movieDetailResponse = ArrayList<DetailMovieResponse>()

        movieDetailResponse.add(
            DetailMovieResponse(
                "en",
                "tt0293429",
                false,
                "Mortal Kombat",
                "",
                50115000,
                arrayListOf(
                    GenresItem(
                        "Fantasy",
                        14
                    ),
                    GenresItem(
                        "Action",
                        28
                    ),
                    GenresItem(
                        "Adventure",
                        12
                    ),
                    GenresItem(
                        "Science Fiction",
                        878
                    ),
                    GenresItem(
                        "Thriller",
                        53
                    ),
                ),
                8009.461,
                arrayListOf(
                    ProductionCountriesItem(
                        "AU",
                        "Australia"
                    ),
                    ProductionCountriesItem(
                        "US",
                        "United States of America"
                    )
                ),
                460465,
                2004,
                20000000,
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, " +
                        "seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high " +
                        "stakes battle for the universe.",
                "Mortal Kombat",
                110,
                "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                arrayListOf(
                    SpokenLanguagesItem(
                        "日本語",
                        "ja",
                        "Japanese"
                    ),
                    SpokenLanguagesItem(
                        "English",
                        "en",
                        "English"
                    ),
                    SpokenLanguagesItem(
                        "普通话",
                        "zn",
                        "Mandarin"
                    )
                ),
                arrayListOf(
                    ProductionCompaniesItem(
                        "/wChlWsVgwSd4ZWxTIm8PTEcaESz.png",
                        "Atomic Monster",
                        76907,
                        "US"
                    ),
                    ProductionCompaniesItem(
                        "/f8NwLg72BByt3eav7lX1lcJfe60.png",
                        "Broken Road Productions",
                        8000,
                        "US"
                    ),
                    ProductionCompaniesItem(
                        "/iaYpEp3LQmb8AfAtmTvpqd4149c.png",
                        "New Line Cinema",
                        12,
                        "US"
                    ),
                    ProductionCompaniesItem(
                        "/IuAlhI9eVC9Z8UQWOIDdWRKSEJ.png",
                        "Warner Bros. Pictures",
                        174,
                        "US"
                    ),
                    ProductionCompaniesItem(
                        "/vxOhCbpsRBh10m6LZ3HyImTYpPY.png",
                        "South Australian Film Corporation",
                        2806,
                        "AU"
                    ),
                    ProductionCompaniesItem(
                        null,
                        "NetherRealm Studios",
                        13033,
                        "US"
                    )
                ),
                "2021-04-07",
                7.8,
                "Get over here.",
                false,
                "https://www.mortalkombatmovie.net",
                "Released"
            )
        )

        movieDetailResponse.add(
            DetailMovieResponse(
                "en",
                "tt5034838",
                false,
                "Godzilla vs. Kong",
                "/inJjDhCjfhh3RtrJWBmmDqeuSYC.jpg",
                406575844,
                arrayListOf(
                    GenresItem(
                        "Science Fiction",
                        878
                    ),
                    GenresItem(
                        "Action",
                        28
                    ),
                    GenresItem(
                        "Drama",
                        18
                    ),
                ),
                3280.437,
                arrayListOf(
                    ProductionCountriesItem(
                        "US",
                        "United States of America"
                    )
                ),
                399566,
                5223,
                160000000,
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course " +
                        "that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "Godzilla vs. Kong",
                113,
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                arrayListOf(
                    SpokenLanguagesItem(
                        "English",
                        "en",
                        "English"
                    )
                ),
                arrayListOf(
                    ProductionCompaniesItem(
                        "/IuAlhI9eVC9Z8UQWOIDdWRKSEJ.png",
                        "Warner Bros. Pictures",
                        174,
                        "US"
                    ),
                    ProductionCompaniesItem(
                        "/5UQsZrfbfG2dYJbx8DxfoTr2Bvu.png",
                        "Legendary Pictures",
                        923,
                        "US"
                    )
                ),
                "2021-03-24",
                8.2,
                "One Will Fall",
                false,
                "https://www.godzillavskong.net/",
                "Released"
            )
        )

        return  movieDetailResponse
    }

    fun generateDummyTvShowResponse(): List<ResultsItemTvShow> {
        val showResponse = ArrayList<ResultsItemTvShow>()

        showResponse.add(ResultsItemTvShow(
            "2021-03-19",
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, " +
                    "Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            "en",
            arrayListOf(
                10765,
                10759,
                18,
                10768
            ),
            "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            arrayListOf(
                "US"
            ),
            "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
            "The Falcon and the Winter Soldier",
            2556.792,
            7.9,
            "The Falcon and the Winter Soldier",
            88396,
            5208
        )
        )

        showResponse.add(ResultsItemTvShow(
            "2021-03-26",
            "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. " +
                    "Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
            "en",
            arrayListOf(
                16,
                10759,
                18,
                10765
            ),
            "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
            arrayListOf(
                "US"
            ),
            "/6UH52Fmau8RPsMAbQbjwN3wJSCj.jpg",
            "Invincible",
            2141.883,
            8.9,
            "Invincible",
            95557,
            1160
        )
        )

        showResponse.add(ResultsItemTvShow(
            "2021-03-31",
            "Real people's terrifying tales of the chilling, unexplained and paranormal come to life with dramatic reenactments in this reality series.",
            "en",
            arrayListOf(
                10764
            ),
            "/Q1ZYG3kDS8iVIHOYOJ9NQmV0q7.jpg",
            arrayListOf(),
            "/lEZLrd3N9nIk5fnCL30GsboCEmB.jpg",
            "Haunted: Latin America",
            1084.486,
            7.4,
            "Haunted: Latin America",
            120587,
            200
        )
        )

        showResponse.add(ResultsItemTvShow(
            "2017-09-25",
            "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. " +
                    "The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
            "en",
            arrayListOf(
                18
            ),
            "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
            arrayListOf(),
            "/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg",
            "The Good Doctor",
            1333.87,
            8.6,
            "The Good Doctor",
            71712,
            8228
        )
        )

        showResponse.add(ResultsItemTvShow(
            "2014-10-07",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. " +
                    "Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian " +
                    "angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was " +
                    "created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with " +
                    "S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that " +
                    "Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "en",
            arrayListOf(
                18,
                10765
            ),
            "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            arrayListOf(),
            "/z59kJfcElR9eHO9rJbWp4qWMuee.jpg",
            "The Flash",
            1278.126,
            7.7,
            "The Flash",
            60735,
            7492
        )
        )

        return showResponse

    }

    fun generateDummyDetailTvShowResponse(): List<DetailTvShowResponse> {
        val showDetailResponse = ArrayList<DetailTvShowResponse>()

        showDetailResponse.add(
            DetailTvShowResponse(
                "en",
                6,
                arrayListOf(
                    NetworksItem(
                        "/gJ8VX6JSu3ciXHuC2dDGAo2lvwM.png",
                        "Disney+",
                        2739,
                        "US"
                    )
                ),
                "Miniseries",
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                arrayListOf(
                    GenresItem02(
                        "Sci-Fi & Fantasy",
                        10765
                    ),
                    GenresItem02(
                        "Action & Adventure",
                        10759
                    ),
                    GenresItem02(
                        "Drama",
                        18
                    ),
                    GenresItem02(
                        "War & Politics",
                        10768
                    ),
                ),
                2556.792,
                arrayListOf(
                    ProductionCountriesItem02(
                        "US",
                        "United States of America"
                    )
                ),
                88396,
                1,
                5208,
                "2021-03-19",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes " +
                        "team up in a global adventure that tests their abilities, and their patience.",
                arrayListOf(
                    SeasonsItem(
                        "2021-03-19",
                        "",
                        6,
                        "Season 1",
                        1,
                        156676,
                        "/fIT6Y6O3cUX1X8qY8pZgzEvxUDQ.jpg"
                    )
                ),
                arrayListOf(
                    "en"
                ),
                arrayListOf(
                    CreatedByItem(
                        2,
                        "605508e2960cde00721fc5e8",
                        "Malcolm Spellman",
                        null,
                        1868712
                    )
                ),
                LastEpisodeToAir(
                    "",
                    "2021-04-23",
                    "As The Flag Smashers escalate their efforts, Sam and Bucky take action.",
                    6,
                    6.6,
                    "One World, One People",
                    1,
                    2558743,
                    "/qXxCqMP7aj3rGndhVfGUyyU6hyq.jpg",
                    5
                ),
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                arrayListOf(
                    "US"
                ),
                arrayListOf(
                    SpokenLanguagesItem02(
                        "English",
                        "en",
                        "English"
                    )
                ),
                "The Falcon and the Winter Soldier",
                7.9,
                "The Falcon and the Winter Soldier",
                "Honor the shield.",
                arrayListOf(
                    50
                ),
                null,
                false,
                "2021-04-23",
                "https://www.disneyplus.com/series/the-falcon-and-the-winter-soldier/4gglDBMx8icA",
                "Ended"
            )
        )

        return showDetailResponse
    }

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