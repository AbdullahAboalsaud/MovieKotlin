package com.example.moviekotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviekotlin.databinding.ItemMovieBinding
import com.example.moviekotlin.models.MovieModel
import com.example.moviekotlin.models.Result

class AdapterMovies : RecyclerView.Adapter<AdapterMovies.MyHolder>() {

    lateinit var movieList: List<Result>
    lateinit var onItemClicked: OnItemClicked


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding: ItemMovieBinding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
       holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class MyHolder(binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        private var binding: ItemMovieBinding


        init {
            this.binding = binding
            binding.root.setOnClickListener(View.OnClickListener {
                onItemClicked.onClicked(movieList[layoutPosition].id)
            })
        }

        fun bind(movieModel:Result){
            binding.textTitle.text = movieModel.title
            Glide.with(binding.root.context)
                .load("https://image.tmdb.org/t/p/w500/"+movieModel.backdropPath)
                .into(binding.imageMovie)
        }
    }

    interface OnItemClicked {
        fun onClicked(id: Int)
    }

}