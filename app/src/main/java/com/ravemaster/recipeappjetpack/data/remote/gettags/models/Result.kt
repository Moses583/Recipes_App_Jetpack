package com.ravemaster.recipeappjetpack.data.remote.gettags.models

data class Result(
    val display_name: String,
    val id: Int,
    val name: String,
    val parent_tag_name: String,
    val root_tag_type: String,
    val type: String
)