package com.example.appmovie.api

import com.example.appmovie.utils.Constants.API_KEY
import com.example.appmovie.utils.Constants.BASE_URL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    private lateinit var retrofit: Retrofit
    private val requestInterceptor = Interceptor{chain ->
        val url = chain.request()
            .url
            .newBuilder()
            .addPathSegment(API_KEY)
            .build()

        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()
        return@Interceptor chain.proceed(request)

    }
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(requestInterceptor)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()

    //Чтобы отправлять запросы к API,
    // нужно использовать класс построителя Retrofit и указать базовый URL-адрес.
    fun getClient(): Retrofit {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
}