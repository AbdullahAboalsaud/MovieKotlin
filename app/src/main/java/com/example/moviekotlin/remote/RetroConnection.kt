package com.example.moviekotlin.remote

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetroConnection {

    companion object {

        private lateinit var retrofit: Retrofit

        fun getRetrofit(): Retrofit {

                retrofit = Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

            return retrofit

        }

        fun getInstance(): ApiCall {
            return getRetrofit().create(ApiCall::class.java)
        }

    }

}




