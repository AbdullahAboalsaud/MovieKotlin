package com.example.moviekotlin

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.moviekotlin.adapters.AdapterMovies
import com.example.moviekotlin.databinding.ActivityMainBinding
import com.example.moviekotlin.models.MovieModel
import com.example.moviekotlin.models.Result
import com.example.moviekotlin.mvvm.DetailsActivity
import com.example.moviekotlin.mvvm.MainViewModel
import java.io.Serializable


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapterMovies: AdapterMovies = AdapterMovies()
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.getMovie()
        viewModel.movieLiveData.observe(this) { list ->
            adapterMovies.movieList = list
            binding.recyclerMovies.adapter = adapterMovies

            adapterMovies.onItemClicked = object : AdapterMovies.OnItemClicked {
                override fun onClicked(id: Int) {

                    for (i in list.indices) {
                        if (list[i].id == id) {
                            val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                            intent.putExtra("posId", id)
                            intent.putExtra("overView", list[i].overview)
                            intent.putExtra("originalLanguage", list[i].originalLanguage)
                            intent.putExtra("title", list[i].title)
                            intent.putExtra("voteAverage", list[i].voteAverage)
                            intent.putExtra("voteCount", list[i].voteCount)
                            intent.putExtra("backdropPath", list[i].backdropPath)
                            startActivity(intent)

                        }
                    }
                }

            }


        }


    }

}





