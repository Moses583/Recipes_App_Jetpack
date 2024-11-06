package com.ravemaster.recipeappjetpack.data.remote.models

data class Section(
    val components: List<Component>,
    val name: String,
    val position: Int
)