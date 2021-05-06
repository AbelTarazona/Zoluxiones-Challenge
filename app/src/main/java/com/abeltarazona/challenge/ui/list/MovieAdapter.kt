package com.abeltarazona.challenge.ui.list

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.abeltarazona.challenge.R
import com.abeltarazona.challenge.databinding.ItemMovieBinding
import com.abeltarazona.challenge.extension.inflate
import com.abeltarazona.domain.models.Movie
import com.bumptech.glide.RequestManager
import javax.inject.Inject

/**
 * Created by AbelTarazona on 5/05/2021
 */
class MovieAdapter @Inject constructor(
    private val glide: RequestManager
) : ListAdapter<Movie, MovieAdapter.Holder>(MovieDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = parent.inflate(R.layout.item_movie)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemMovieBinding.bind(view)
        fun bind(data: Movie) {
            with(binding) {
                tvTitle.text = data.title
                glide.load(data.getImagePoster()).into(ivPoster)
            }
        }
    }
}


class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }

}