package com.ravemaster.recipeappjetpack.data.remote.getfeed.models

data class Component(
    val extra_comment: String,
    val hacks: List<Hack>,
    val id: Int,
    val ingredient: Ingredient,
    val measurements: List<Measurement>,
    val position: Int,
    val raw_text: String
)