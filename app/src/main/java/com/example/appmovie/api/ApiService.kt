package com.example.appmovie.api

import com.example.appmovie.response.MovieList
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    //делаем get запрос для получения данных с сервера
    @GET("en/API/MostPopularMovies/")
    fun getPopularMovies(): Call<MovieList>
}