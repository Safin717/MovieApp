package com.example.appmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appmovie.adapter.MovieAdapter
import com.example.appmovie.api.ApiClient
import com.example.appmovie.api.ApiService
import com.example.appmovie.databinding.ActivityMainBinding
import com.example.appmovie.response.MovieList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    //данная переменная будет инициализирована позже
    private lateinit var binding: ActivityMainBinding
    private val movieAdapter = MovieAdapter()
    private val api:ApiService = ApiClient().getClient().create(ApiService::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            pbMovie.visibility = View.VISIBLE
            val callMovieApi = api.getPopularMovies()
            callMovieApi.enqueue(object : Callback<MovieList> {
                override fun onResponse(
                    call: Call<MovieList>,
                    response: Response<MovieList>
                ) {
                    pbMovie.visibility = View.GONE
                    Log.d("Movies:", "${response.body()}")
                    when (response.code()) {
                        in 200..299 -> {
                            response.body().let { itBody ->
                                itBody?.items.let { itData ->
                                    if (itData!!.isNotEmpty()) {
                                        movieAdapter.differ.submitList(itData)
                                        rvMovie.apply {
                                            layoutManager = LinearLayoutManager(this@MainActivity)
                                            adapter = movieAdapter
                                        }
                                    }
                                }
                            }
                        }
                        in 300..399 -> {
                            Toast.makeText(this@MainActivity,"Ошибка перенаправления: ${response.code()}", Toast.LENGTH_SHORT).show()
                        }
                        in 400..499 -> {
                            Toast.makeText(this@MainActivity,"Проверьте доступ в интернет: ${response.code()}", Toast.LENGTH_SHORT).show()
                        }
                        in 500..599 -> {
                            Toast.makeText(this@MainActivity,"Серверная ошибка: ${response.code()}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                override fun onFailure(call: Call<MovieList>, t: Throwable) {
                    binding.pbMovie.visibility = View.GONE
                }
            })
        }
    }
}