package com.ravemaster.recipeappjetpack.data.remote.getfeed.models

data class ComponentXX(
    val extra_comment: String,
    val hacks: List<Hack>,
    val id: Int,
    val ingredient: Ingredient,
    val linked_recipe: LinkedRecipe,
    val measurements: List<Measurement>,
    val position: Int,
    val raw_text: String
)