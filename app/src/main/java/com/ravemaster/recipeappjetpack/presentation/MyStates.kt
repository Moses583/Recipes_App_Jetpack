package com.ravemaster.recipeappjetpack.presentation

import com.ravemaster.recipeappjetpack.data.remote.models.RecipesListResponse

data class MyStates(
    val recipesListResponse: RecipesListResponse? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)