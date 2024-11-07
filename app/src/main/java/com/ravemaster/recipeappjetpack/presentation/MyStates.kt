package com.ravemaster.recipeappjetpack.presentation

import com.ravemaster.recipeappjetpack.data.remote.getrecipeslist.models.RecipesListResponse

data class MyStates(
    val recipesListResponse: RecipesListResponse? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)