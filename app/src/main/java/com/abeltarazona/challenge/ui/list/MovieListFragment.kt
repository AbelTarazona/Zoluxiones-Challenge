package com.abeltarazona.challenge.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.abeltarazona.challenge.R
import com.abeltarazona.challenge.base.BaseFragment
import com.abeltarazona.challenge.databinding.FragmentMovieListBinding
import com.abeltarazona.challenge.extension.observe
import com.abeltarazona.presentation.viewmodel.BaseViewModel
import com.abeltarazona.presentation.viewmodel.MovieListViewModel
import com.abeltarazona.presentation.viewmodel.MovieUIModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieListFragment : BaseFragment<FragmentMovieListBinding, BaseViewModel>() {

    override val viewModel: MovieListViewModel by viewModels()

    override val layoutId: Int = R.layout.fragment_movie_list

    @Inject
    lateinit var movieAdapter: MovieAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getMovies(1)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.getMovies(), ::onViewStateChange)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        viewBinding.rvItems.apply {
            adapter = movieAdapter
        }

/*        characterAdapter.setItemClickListener { character ->
            findNavController().navigate(
                CharacterListFragmentDirections.actionCharacterListFragmentToCharacterDetailFragment(
                    character.id.toLong()
                )
            )
        }*/
    }

    private fun onViewStateChange(event: MovieUIModel) {
        if (event.isRedelivered) return
        when (event) {
            is MovieUIModel.Error -> handleErrorMessage(event.error)
            MovieUIModel.Loading -> handleLoading(true)
            is MovieUIModel.Success -> {
                handleLoading(false)
                event.data.let {
                    movieAdapter.submitList(it)
                }
            }
        }
    }


}