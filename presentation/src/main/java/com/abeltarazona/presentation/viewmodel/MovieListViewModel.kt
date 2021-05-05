package com.abeltarazona.presentation.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import com.abeltarazona.domain.interactor.GetMovieListUseCase
import com.abeltarazona.domain.models.Movie
import com.abeltarazona.presentation.utils.ExceptionHandler
import com.abeltarazona.presentation.utils.UiAwareLiveData
import com.abeltarazona.presentation.utils.UiAwareModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.collect

/**
 * Created by AbelTarazona on 5/05/2021
 */

private const val TAG = "MovieListViewModel"

sealed class MovieUIModel : UiAwareModel() {
    object Loading : MovieUIModel()
    data class Error(var error: String = "") : MovieUIModel()
    data class Success(val data: List<Movie>) : MovieUIModel()
}

class MovieListViewModel @ViewModelInject constructor(
    private val movieListUseCase: GetMovieListUseCase
) : BaseViewModel() {

    private val _movieList = UiAwareLiveData<MovieUIModel>()
    private var movieList: LiveData<MovieUIModel> = _movieList

    fun getMovies(): LiveData<MovieUIModel> = movieList


    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.d(TAG, exception.message ?: "Error ")
        val message = ExceptionHandler.parse(exception)
        _movieList.postValue(MovieUIModel.Error(exception.message ?: "Error"))
    }
    
    fun getMovies(page: Int) {
        _movieList.postValue(MovieUIModel.Loading)
        launchCoroutineIO {
            loadMovies(page)
        }
    }

    private suspend fun loadMovies(page: Int) {
        movieListUseCase(params = page).collect { value: List<Movie> ->
            Log.d(TAG, "called again: $value")
            _movieList.postValue(MovieUIModel.Success(value))
        }
    }
}