package com.example.moviekotlin

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.moviekotlin.models.MovieModel
import com.example.moviekotlin.models.Result
import com.example.moviekotlin.remote.RetroConnection
import com.example.moviekotlin.room.MyDatabase
import io.reactivex.CompletableObserver
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlin.math.log

class Repo {
    val movieLiveData: MutableLiveData<List<Result>> = MutableLiveData()

    fun getMovieRemote() {
        RetroConnection.getInstance()
            .getMovie("300cbeb8d36e791cf85879629cf221f4")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<MovieModel> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onSuccess(movieModel: MovieModel) {
                    cacheMovies(movieModel.results)
                    movieLiveData.value = movieModel.results
                }

                override fun onError(e: Throwable) {
                    getMovieLocal()
                }

            })

    }

    fun getMovieLocal() {

        MyDatabase.getMyDatabase().getDao()
            .getMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :SingleObserver<List<Result>>{
                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    Log.e("TAG", "onError: ")
                }

                override fun onSuccess(t: List<Result>) {
                    movieLiveData.value = t
                }
            })
        }
    }



    fun cacheMovies(list: List<Result>) {
        MyDatabase.getMyDatabase().getDao()
            .insert(list)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }


