package com.example.moviekotlin.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide

import com.example.moviekotlin.databinding.ActivityDetailsBinding



class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val overView = intent.getStringExtra("overView")
        val backdropPath = intent.getStringExtra("backdropPath")
        val originalLanguage = intent.getStringExtra("originalLanguage")
        val title = intent.getStringExtra("title")
        val voteAverage = intent.getDoubleExtra("voteAverage", 0.0)
        val voteCount = intent.getIntExtra("voteCount", 0)


        binding.tvTitle.text = title

        Glide.with(binding.root.context)
            .load("https://image.tmdb.org/t/p/w500/" + backdropPath.toString())
            .into(binding.movieImg)

        binding.tvOverview.text = overView
        binding.tvLang.text = originalLanguage
        binding.tvVote.text = voteAverage.toString()

        binding.tvVoteCount.text = voteCount.toString()


    }


}
