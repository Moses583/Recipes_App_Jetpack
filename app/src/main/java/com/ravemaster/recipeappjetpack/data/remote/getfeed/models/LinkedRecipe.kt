package com.ravemaster.recipeappjetpack.data.remote.getfeed.models

data class LinkedRecipe(
    val approved_at: Int,
    val id: Int,
    val name: String,
    val slug: String,
    val thumbnail_url: String
)