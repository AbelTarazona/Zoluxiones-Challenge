package com.abeltarazona.challenge.ui.detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.abeltarazona.challenge.R
import com.abeltarazona.challenge.base.BaseNativeFragment
import com.abeltarazona.challenge.databinding.FragmentMovieDetailBinding
import com.abeltarazona.domain.models.Movie
import com.bumptech.glide.RequestManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieDetailFragment : BaseNativeFragment<FragmentMovieDetailBinding>() {

    override val layoutId: Int = R.layout.fragment_movie_detail

    private val args: MovieDetailFragmentArgs by navArgs()

    @Inject
    lateinit var glide: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        sharedElementReturnTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movie: Movie = args.movie

        viewBinding.ivPoster.transitionName = movie.id.toString()
        glide.load(args.movie.getImagePoster()).into(viewBinding.ivPoster)

        viewBinding.tvTitle.text = movie.title
        viewBinding.tvDate.text = movie.date
        viewBinding.tvDetail.text = movie.overview
        viewBinding.tvValue.text = "${movie.voteAverage} ⭐"
    }

}