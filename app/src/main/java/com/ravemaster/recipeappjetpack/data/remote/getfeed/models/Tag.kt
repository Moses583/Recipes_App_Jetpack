package com.ravemaster.recipeappjetpack.data.remote.getfeed.models

data class Tag(
    val display_name: String,
    val id: Int,
    val name: String,
    val parent_tag_name: String,
    val root_tag_type: String,
    val type: String
)