package com.example.appmovie.response

import com.google.gson.annotations.SerializedName

data class DetailsMovieList(
    @SerializedName("actorList")
    val actorList: List<Actor>,
    @SerializedName("awards")
    val awards: String, // Top rated movie #14 | Won 4 Oscars, 158 wins & 220 nominations total
    @SerializedName("boxOffice")
    val boxOffice: BoxOffice,
    @SerializedName("companies")
    val companies: String, // Warner Bros., Legendary Entertainment, Syncopy
    @SerializedName("companyList")
    val companyList: List<Company>,
    @SerializedName("contentRating")
    val contentRating: String, // PG-13
    @SerializedName("countries")
    val countries: String, // USA, UK
    @SerializedName("countryList")
    val countryList: List<Country>,
    @SerializedName("directorList")
    val directorList: List<Director>,
    @SerializedName("directors")
    val directors: String, // Christopher Nolan
    @SerializedName("errorMessage")
    val errorMessage: Any, // null
    @SerializedName("fullCast")
    val fullCast: Any, // null
    @SerializedName("fullTitle")
    val fullTitle: String, // Inception (2010)
    @SerializedName("genreList")
    val genreList: List<Genre>,
    @SerializedName("genres")
    val genres: String, // Action, Adventure, Sci-Fi
    @SerializedName("id")
    val id: String, // tt1375666
    @SerializedName("imDbRating")
    val imDbRating: String, // 8.8
    @SerializedName("imDbRatingVotes")
    val imDbRatingVotes: String, // 2332127
    @SerializedName("image")
    val image: String, // https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_Ratio0.6762_AL_.jpg
    @SerializedName("images")
    val images: Any, // null
    @SerializedName("keywordList")
    val keywordList: List<String>,
    @SerializedName("keywords")
    val keywords: String, // dream,ambiguous ending,subconscious,mindbender,surprise ending
    @SerializedName("languageList")
    val languageList: List<Language>,
    @SerializedName("languages")
    val languages: String, // English, Japanese, French
    @SerializedName("metacriticRating")
    val metacriticRating: String, // 74
    @SerializedName("originalTitle")
    val originalTitle: String,
    @SerializedName("plot")
    val plot: String, // A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.
    @SerializedName("plotLocal")
    val plotLocal: String,
    @SerializedName("plotLocalIsRtl")
    val plotLocalIsRtl: Boolean, // false
    @SerializedName("posters")
    val posters: Any, // null
    @SerializedName("ratings")
    val ratings: Any, // null
    @SerializedName("releaseDate")
    val releaseDate: String, // 2010-07-16
    @SerializedName("runtimeMins")
    val runtimeMins: String, // 148
    @SerializedName("runtimeStr")
    val runtimeStr: String, // 2h 28min
    @SerializedName("similars")
    val similars: List<Similar>,
    @SerializedName("starList")
    val starList: List<Star>,
    @SerializedName("stars")
    val stars: String, // Leonardo DiCaprio, Joseph Gordon-Levitt, Elliot Page
    @SerializedName("tagline")
    val tagline: Any, // null
    @SerializedName("title")
    val title: String, // Inception
    @SerializedName("trailer")
    val trailer: Any, // null
    @SerializedName("tvEpisodeInfo")
    val tvEpisodeInfo: Any, // null
    @SerializedName("tvSeriesInfo")
    val tvSeriesInfo: Any, // null
    @SerializedName("type")
    val type: String, // Movie
    @SerializedName("wikipedia")
    val wikipedia: Any, // null
    @SerializedName("writerList")
    val writerList: List<Writer>,
    @SerializedName("writers")
    val writers: String, // Christopher Nolan
    @SerializedName("year")
    val year: String // 2010
) {
    data class Actor(
        @SerializedName("asCharacter")
        val asCharacter: String, // Cobb
        @SerializedName("id")
        val id: String, // nm0000138
        @SerializedName("image")
        val image: String, // https://m.media-amazon.com/images/M/MV5BMjI0MTg3MzI0M15BMl5BanBnXkFtZTcwMzQyODU2Mw@@._V1_Ratio1.0000_AL_.jpg
        @SerializedName("name")
        val name: String // Leonardo DiCaprio
    )

    data class BoxOffice(
        @SerializedName("budget")
        val budget: String, // $160,000,000 (estimated)
        @SerializedName("cumulativeWorldwideGross")
        val cumulativeWorldwideGross: String, // $836,848,102
        @SerializedName("grossUSA")
        val grossUSA: String, // $292,587,330
        @SerializedName("openingWeekendUSA")
        val openingWeekendUSA: String // $62,785,337
    )

    data class Company(
        @SerializedName("id")
        val id: String, // co0002663
        @SerializedName("name")
        val name: String // Warner Bros.
    )

    data class Country(
        @SerializedName("key")
        val key: String, // USA
        @SerializedName("value")
        val value: String // USA
    )

    data class Director(
        @SerializedName("id")
        val id: String, // nm0634240
        @SerializedName("name")
        val name: String // Christopher Nolan
    )

    data class Genre(
        @SerializedName("key")
        val key: String, // Action
        @SerializedName("value")
        val value: String // Action
    )

    data class Language(
        @SerializedName("key")
        val key: String, // English
        @SerializedName("value")
        val value: String // English
    )

    data class Similar(
        @SerializedName("id")
        val id: String, // tt0816692
        @SerializedName("imDbRating")
        val imDbRating: String, // 8.6
        @SerializedName("image")
        val image: String, // https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_Ratio0.6763_AL_.jpg
        @SerializedName("title")
        val title: String // Interstellar
    )

    data class Star(
        @SerializedName("id")
        val id: String, // nm0000138
        @SerializedName("name")
        val name: String // Leonardo DiCaprio
    )

    data class Writer(
        @SerializedName("id")
        val id: String, // nm0634240
        @SerializedName("name")
        val name: String // Christopher Nolan
    )
}
