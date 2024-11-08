package com.ravemaster.recipeappjetpack.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ravemaster.recipeappjetpack.data.remote.getfeed.models.FeedsApiResponse
import com.ravemaster.recipeappjetpack.domain.repository.FeedRepository
import com.ravemaster.recipeappjetpack.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedsViewModel @Inject constructor(
    private val feedRepository: FeedRepository
): ViewModel(){

    private val _feeds = MutableStateFlow(
        FeedsApiResponse(
            results = emptyList()
        )
    )
    val feeds = _feeds.asStateFlow()

    private val _errors = MutableStateFlow("")
    val errors = _errors.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    fun getFeeds(size: Int, from: Int){

        viewModelScope.launch {

            feedRepository.getFeeds(size = size, from = from).collectLatest {
                    result ->
                when(result){
                    is Resource.Error -> {
                        _loading.value = false
                        val errorMessage = result.message
                        if (errorMessage != null) {
                            _errors.value = errorMessage
                        }
                    }
                    is Resource.Loading -> {
                        _loading.value = true
                        _errors.value = ""

                    }
                    is Resource.Success -> {
                        _loading.value = false
                        result.data?.let {
                                feeds->
                            _feeds.update { feeds }
                        }

                    }
                }
            }
        }
    }

}