package com.example.moviekotlin.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviekotlin.Repo
import com.example.moviekotlin.models.Result


class MainViewModel : ViewModel() {
    var movieLiveData: MutableLiveData<List<Result>>
    private val repo = Repo()

    init {
        movieLiveData = repo.movieLiveData
    }

    fun getMovie() {
        repo.getMovieRemote()
    }


}