package com.example.moviekotlin.remote

import com.example.moviekotlin.models.MovieModel
import com.example.moviekotlin.models.Result
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCall {

    @GET("discover/movie")
    fun getMovie(@Query("api_key") apiKey: String): Single<MovieModel>

}