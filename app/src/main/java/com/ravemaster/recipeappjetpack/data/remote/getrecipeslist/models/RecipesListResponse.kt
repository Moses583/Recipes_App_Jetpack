package com.ravemaster.recipeappjetpack.data.remote.getrecipeslist.models

data class RecipesListResponse(
    val count: Int,
    val results: List<Result>
)