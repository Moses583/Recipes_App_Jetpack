package com.ravemaster.recipeappjetpack.data.remote.getrecipeslist.models

data class UserRatings(
    val count_negative: Int,
    val count_positive: Int,
    val score: Double
)