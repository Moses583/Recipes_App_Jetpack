package com.ravemaster.recipeappjetpack.data.remote.getfeed.models

data class Price(
    val consumption_portion: Double,
    val consumption_total: Double,
    val portion: Double,
    val total: Double,
    val updated_at: String
)