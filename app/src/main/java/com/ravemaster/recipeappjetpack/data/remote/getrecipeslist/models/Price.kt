package com.ravemaster.recipeappjetpack.data.remote.getrecipeslist.models

data class Price(
    val consumption_portion: Int,
    val consumption_total: Int,
    val portion: Int,
    val total: Int,
    val updated_at: String
)