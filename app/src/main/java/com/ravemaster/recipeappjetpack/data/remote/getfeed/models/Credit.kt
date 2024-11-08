package com.ravemaster.recipeappjetpack.data.remote.getfeed.models

data class Credit(
    val is_verified: Boolean,
    val name: String,
    val picture_url: String,
    val type: String,
    val user_id: Int
)