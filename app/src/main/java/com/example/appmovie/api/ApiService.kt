package com.example.appmovie.api

import com.example.appmovie.response.DetailsMovieList
import com.example.appmovie.response.MovieList
import com.example.appmovie.utils.Constants.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    //делаем get запрос для получения данных с сервера
    @GET("ru/API/MostPopularMovies/")
    fun getPopularMovies(): Call<MovieList>

    //гет запрос для получения описания фильма по id
    @GET("ru/API/Title/$API_KEY/{id}")
    fun getMovieDetails(@Path("id") id: String):Call<DetailsMovieList>
}