package com.ravemaster.recipeappjetpack.data.remote.getrecipeslist.models

data class Section(
    val components: List<Component>,
    val name: String,
    val position: Int
)