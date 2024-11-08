package com.ravemaster.recipeappjetpack.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ravemaster.recipeappjetpack.data.remote.getrecipeslist.models.RecipesListResponse
import com.ravemaster.recipeappjetpack.domain.repository.RecipesListRepository
import com.ravemaster.recipeappjetpack.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetRecipesViewModel @Inject constructor(
    private val recipesListRepository: RecipesListRepository
): ViewModel() {

    private val _recipes = MutableStateFlow(
        RecipesListResponse(
            count = 0 ,
            results = emptyList()
        )
    )
    val recipes = _recipes.asStateFlow()

    private val _errors = MutableStateFlow("")
    val errors = _errors.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()



    fun getRecipes(from: Int, size: Int,tags: String){

        viewModelScope.launch {

            recipesListRepository.getRecipes(from,size,tags).collectLatest {
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
                            _recipes.update { recipes }
                        }

                    }
                }
            }
        }
    }

}