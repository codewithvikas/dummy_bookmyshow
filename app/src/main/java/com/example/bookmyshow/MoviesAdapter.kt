package com.example.bookmyshow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item_layout.view.*

class MoviesAdapter(private val movies:List<Movie>): RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    companion object {
        // Base URL for image: MoviesAdapter.kt file
        private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout,parent,false)
        return MoviesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount():Int = movies.count()

    class MoviesViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        fun bind(movie:Movie){
            itemView.movie_title.text = movie.title
            itemView.release_date.text = movie.releaseDate
            itemView.avg_voting.text = movie.voteAverage.toString()
            itemView.total_votes.text = movie.voteCount.toString()

            Glide.with(itemView.context).load(movie.posterPath).into(itemView.movie_poster)
        }
    }



}