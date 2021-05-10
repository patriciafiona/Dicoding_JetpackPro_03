package com.path_studio.moviecatalogue.util

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

    /*fun generateDummyMovie(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, " +
                    "Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of " +
                    "Outworld in a high stakes battle for the universe.",
            "Mortal Kombat",
            "Mortal Kombat",
            "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
            "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
            "2021-04-07",
            7.9,
            460465
        )
        )

        movies.add(
            MovieEntity(
            "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a " +
                    "collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
            "Godzilla vs. Kong",
            "Godzilla vs. Kong",
            "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
            "/inJjDhCjfhh3RtrJWBmmDqeuSYC.jpg",
            "2021-03-24",
            8.2,
            399566
        )
        )

        movies.add(
            MovieEntity(
            "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his " +
                    "home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark " +
                    "secrets he fought to leave behind.",
            "Nobody",
            "Nobody",
            "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
            "/6zbKgwgaaCyyBXE4Sun4oWQfQmi.jpg",
            "2021-03-18",
            8.5,
            615457
        )
        )

        movies.add(
            MovieEntity(
            "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with " +
                    "plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
            "Zack Snyder's Justice League",
            "Zack Snyder's Justice League",
            "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
            "/pcDc2WJAYGJTTvRSEIpRZwM3Ola.jpg",
            "2021-03-18",
            8.5,
            791373
        )
        )

        movies.add(
            MovieEntity(
            "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, " +
                    "is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and " +
                    "far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the " +
                    "small New England town to investigate. When terrifying events begin to happen all around, he starts " +
                    "to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
            "The Unholy",
            "The Unholy",
            "/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
            "/zDq2pwPyt4xwSFHKUoNN2LohDWj.jpg",
            "2021-03-31",
            5.7,
            632357
        )
        )

        movies.add(
            MovieEntity(
            "In a world where supervillains are commonplace, two estranged childhood best friends reunite after " +
                    "one devises a treatment that gives them powers to protect their city.",
            "Thunder Force",
            "Thunder Force",
            "/duK11VQd4UPDa7UJrgrGx90xJOx.jpg",
            "/z7HLq35df6ZpRxdMAE0qE3Ge4SJ.jpg",
            "2021-04-09",
            5.8,
            615678
        )
        )

        movies.add(
            MovieEntity(
            "Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – " +
                    "a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother " +
                    "dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will " +
                    "stop at nothing to get him to safety, as they go on the run from the relentless assassins.",
            "The Marksman",
            "The Marksman",
            "/6vcDalR50RWa309vBH1NLmG2rjQ.jpg",
            "/5Zv5KmgZzdIvXz2KC3n0MyecSNL.jpg",
            "2021-01-15",
            7.3,
            634528
        )
        )

        movies.add(
            MovieEntity(
            "Tanjiro Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and " +
                    "Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a " +
                    "new mission with the Fire Hashira, Kyojuro Rengoku, to defeat a demon who has been tormenting the people " +
                    "and killing the demon slayers who oppose it!",
            "劇場版「鬼滅の刃」無限列車編",
            "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train",
            "/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
            "/3FVe3OAdgz060JaxIAaUl5lo6cx.jpg",
            "2020-10-16",
            8.2,
            635302
        )
        )

        movies.add(
            MovieEntity(
            "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet " +
                    "as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
            "Chaos Walking",
            "Chaos Walking",
            "/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg",
            "/ovggmAOu1IbPGTQE8lg4lBasNC7.jpg",
            "2021-02-24",
            7.3,
            412656
        )
        )

        movies.add(
            MovieEntity(
            "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. " +
                    "But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. " +
                    "Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track " +
                    "down the legendary last dragon to restore the fractured land and its divided people.",
            "Raya and the Last Dragon",
            "Raya and the Last Dragon",
            "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
            "/7prYzufdIOy1KCTZKVWpjBFqqNr.jpg",
            "2021-03-03",
            8.3,
            527774
        )
        )

        return movies
    }

    fun generateDummyTvShow(): List<TvShowEntity> {
        val shows = ArrayList<TvShowEntity>()

        shows.add(
            TvShowEntity(
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, " +
                        "Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "The Falcon and the Winter Soldier",
                "The Falcon and the Winter Soldier",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                "2021-03-19",
                7.9,
                88396
            )
        )

        shows.add(
            TvShowEntity(
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. " +
                        "The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "The Good Doctor",
                "The Good Doctor",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg",
                "2017-09-25",
                8.6,
                71712
            )
        )

        shows.add(
            TvShowEntity(
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls " +
                        "into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central " +
                        "City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover " +
                        "he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is " +
                        "using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. " +
                        "For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't " +
                        "be long before the world learns what Barry Allen has become...The Flash.",
                "The Flash",
                "The Flash",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "/z59kJfcElR9eHO9rJbWp4qWMuee.jpg",
                "2014-10-07",
                7.7,
                60735
            )
        )

        shows.add(
            TvShowEntity(
                "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated " +
                        "audiences in Latin America and beyond for decades.",
                "Luis Miguel: La Serie",
                "Luis Miguel: The Series",
                "/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                "/wkyzeBBKLhSg1Oqhky5yoiFF2hG.jpg",
                "2018-04-22",
                8.0,
                79008
            )
        )

        shows.add(
            TvShowEntity(
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "Grey's Anatomy",
                "Grey's Anatomy",
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg",
                "2005-03-27",
                8.2,
                1416
            )
        )

        shows.add(
            TvShowEntity(
                "Vanessa Helsing, the daughter of famous vampire hunter and Dracula nemesis Abraham Van Helsing is resurrected " +
                        "five years in the future to find out that vampires have taken over the world and that she possesses unique power " +
                        "over them. She is humanity’s last hope to lead an offensive to take back what has been lost.",
                "Van Helsing",
                "Van Helsing",
                "/r8ODGmfNbZQlNhiJl2xQENE2jsk.jpg",
                "/5VltHQJXdmbSD6gEJw3R8R1Kbmc.jpg",
                "2016-09-23",
                6.9,
                65820
            )
        )

        shows.add(
            TvShowEntity(
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, " +
                        "exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "Riverdale",
                "Riverdale",
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                "/qZtAf4Z1lazGQoYVXiHOrvLr5lI.jpg",
                "2017-01-26",
                8.6,
                69050
            )
        )

        shows.add(
            TvShowEntity(
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. " +
                        "Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "Invincible",
                "Invincible",
                "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                "/6UH52Fmau8RPsMAbQbjwN3wJSCj.jpg",
                "2021-03-26",
                8.9,
                95557
            )
        )

        shows.add(
            TvShowEntity(
                "After spending seventeen years in prison unfairly, a talented songwriter seeks revenge on the men who sank her and killed her family.",
                "La Reina del Flow",
                "The Queen of Flow",
                "/3T5mSuziI0TMa7z9R5w3vNl2qok.jpg",
                "/lKGi8u6l5PJVSAdOazHjt0n3wHZ.jpg",
                "2018-06-12",
                7.9,
                80240
            )
        )

        shows.add(
            TvShowEntity(
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, " +
                        "where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from " +
                        "the underworld, the greater the threat that the worst of humanity could escape.",
                "Lucifer",
                "Lucifer",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "/ta5oblpMlEcIPIS2YGcq9XEkWK2.jpg",
                "2016-01-25",
                8.5,
                63174
            )
        )

        return shows
    }

    fun generateDummyDetailMovie(): List<DetailMovieEntity> {
        val detailMovies = ArrayList<DetailMovieEntity>()

        detailMovies.add(
            DetailMovieEntity(
            460465,
            "Mortal Kombat",
            "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
            arrayListOf(
                "Fantasy",
                "Action",
                "Adventure",
                "Science Fiction",
                "Thriller"
            ),
            2516,
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, " +
                    "Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld " +
                    "in a high stakes battle for the universe.",
            "Mortal Kombat",
            110,
            "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
            "2021-04-07",
            7.9,
        )
        )

        detailMovies.add(
            DetailMovieEntity(
                527774,
                "Raya and the Last Dragon",
                "/7prYzufdIOy1KCTZKVWpjBFqqNr.jpg",
                arrayListOf(
                        "Animation",
                        "Adventure",
                        "Fantasy",
                        "Family",
                        "Action"
                ),
                2516,
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. " +
                        "But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. " +
                        "Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track " +
                        "down the legendary last dragon to restore the fractured land and its divided people.",
                "Raya and the Last Dragon",
                107,
                "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
                "2021-03-03",
                8.3,
            )
        )

        return detailMovies
    }

    fun generateDummyDetailTvShow(): List<DetailTvShowEntity> {
        val detailTvShows = ArrayList<DetailTvShowEntity>()

        detailTvShows.add(
            DetailTvShowEntity(
                88396,
                "The Falcon and the Winter Soldier",
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
            arrayListOf(
                "Sci-Fi & Fantasy",
                "Action & Adventure",
                "Drama",
                "War & Politics"
            ),
                5043,
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, " +
                        "Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            arrayListOf(
                TvShowSeasonEntity(
                    "2021-03-19",
                    6,
                    156676,
                    "Season 1",
                    "",
                    "/fIT6Y6O3cUX1X8qY8pZgzEvxUDQ.jpg",
                    1
                )
            ),
                "The Falcon and the Winter Soldier",
                arrayListOf(
                    50
                ),
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "2021-03-19",
                7.9
            )
        )

        return detailTvShows
    }*/

}