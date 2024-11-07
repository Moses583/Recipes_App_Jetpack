package com.ravemaster.recipeappjetpack.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ravemaster.recipeappjetpack.data.remote.gettags.models.TagsApiResponse
import com.ravemaster.recipeappjetpack.domain.repository.TagsRepository
import com.ravemaster.recipeappjetpack.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TagsViewModel @Inject constructor(
    private val tagsRepository: TagsRepository
): ViewModel() {

    private val _tags = MutableStateFlow(
        TagsApiResponse(
            count = 0 ,
            next = null,
            prev = null,
            results = emptyList()
        )
    )
    val tags = _tags.asStateFlow()

    private val _errors = MutableStateFlow("")
    val errors = _errors.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    fun getTags(){

        viewModelScope.launch {

            tagsRepository.getTags().collectLatest {
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
                                recipes->
                            _tags.update { recipes }
                        }

                    }
                }
            }
        }
    }

}