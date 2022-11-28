package com.example.appmovie.response

import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("errorMessage")
    val errorMessage: String,
    @SerializedName("items")
    val items: List<Item>
) {
    data class Item(
        @SerializedName("crew")
        val crew: String, // Ryan Coogler (dir.), Letitia Wright, Lupita Nyong'o
        @SerializedName("fullTitle")
        val fullTitle: String, // Black Panther: Wakanda Forever (2022)
        @SerializedName("id")
        val id: String, // tt9114286
        @SerializedName("imDbRating")
        val imDbRating: String, // 7.4
        @SerializedName("imDbRatingCount")
        val imDbRatingCount: String, // 54059
        @SerializedName("image")
        val image: String, // https://m.media-amazon.com/images/M/MV5BNTM4NjIxNmEtYWE5NS00NDczLTkyNWQtYThhNmQyZGQzMjM0XkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_Ratio0.6716_AL_.jpg
        @SerializedName("rank")
        val rank: String, // 1
        @SerializedName("rankUpDown")
        val rankUpDown: String, // +6
        @SerializedName("title")
        val title: String, // Black Panther: Wakanda Forever
        @SerializedName("year")
        val year: String // 2022
    )
}