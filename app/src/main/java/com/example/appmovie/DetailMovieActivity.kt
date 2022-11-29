package com.example.appmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import coil.load
import coil.size.Scale
import com.example.appmovie.api.ApiClient
import com.example.appmovie.api.ApiService
import com.example.appmovie.databinding.ActivityDetailMovieBinding
import com.example.appmovie.response.DetailsMovieList
import com.example.appmovie.utils.Constants.API_KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailMovieBinding
    private val api:ApiService = ApiClient().getClient().create(ApiService::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieId = intent.getStringExtra("id")
        binding.apply {
            val callDetailMovieApi = api.getMovieDetails(movieId.toString())
            callDetailMovieApi.enqueue(object : Callback<DetailsMovieList> {
                override fun onResponse(
                    call: Call<DetailsMovieList>,
                    response: Response<DetailsMovieList>
                ) {
                    Log.d("Details:", "${movieId}")
                    Log.d("Details:", "${response}")
                    when(response.code()){
                        in 200..299 -> {
                            response.body().let {itBody ->
                                val imagePoster = itBody!!.image
                                imgMovie.load(imagePoster){
                                    crossfade(true)
                                    placeholder(R.drawable.poster_placeholder)
                                    scale(Scale.FILL)
                                }
                                imgBackground.load(imagePoster){
                                    crossfade(true)
                                    placeholder(R.drawable.poster_placeholder)
                                    scale(Scale.FILL)
                                }
                                tvMovieName.text = itBody.fullTitle
                                tvTagLine.text = itBody.keywords
                                tvMovieReleased.text = itBody.releaseDate
                                tvMovieRating.text = itBody.imDbRating
                                tvMovieRuntime.text = itBody.runtimeStr
                                tvMovieDescription.text = itBody.plotLocal
                                tvMovieBudget.text = itBody.boxOffice.budget
                                tvMovieRevenue.text = itBody.boxOffice.cumulativeWorldwideGross
                            }
                        }
                        in 300..399 -> {
                            Toast.makeText(this@DetailMovieActivity,"Ошибка перенаправления: ${response.code()}", Toast.LENGTH_SHORT).show()
                        }
                        in 400..499 -> {
                            Toast.makeText(this@DetailMovieActivity,"Проверьте доступ в интернет: ${response.code()}", Toast.LENGTH_SHORT).show()
                        }
                        in 500..599 -> {
                            Toast.makeText(this@DetailMovieActivity,"Серверная ошибка: ${response.code()}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onFailure(call: Call<DetailsMovieList>, t: Throwable) {
                    Toast.makeText(this@DetailMovieActivity,
                        "непредвиденная ошибка при обработке ответа с сервера",
                        Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}