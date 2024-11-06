package com.ravemaster.recipeappjetpack.data.remote.models

data class RecipesListResponse(
    val count: Int,
    val results: List<Result>
)