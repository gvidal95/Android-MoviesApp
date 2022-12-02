package com.example.moviesapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.databinding.ViewMovieItemBinding

interface MovieClickedListener {
    fun onMovieClicked (movie: Movie)
}

class MoviesAdapter(private val movies: List<Movie>, private val movieClickedListener: (Movie) -> Unit):
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ViewMovieItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (movie: Movie){
            binding.title.text = movie.title
            Glide.with(binding.root.context).load(movie.cover).into(binding.cover)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Create a new view
        val binding = ViewMovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Update a new view
        val movie = movies[position]
        holder.bind(movie) //Extract variable shorcut (mac: option+command v)
        holder.itemView.setOnClickListener{ movieClickedListener(movie) }
    }

    //Return number of elements of a adapter
    override fun getItemCount(): Int = movies.size

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}