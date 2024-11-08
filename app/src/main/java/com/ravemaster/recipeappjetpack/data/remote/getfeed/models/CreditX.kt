package com.ravemaster.recipeappjetpack.data.remote.getfeed.models

data class CreditX(
    val id: Int,
    val image_url: String,
    val is_verified: Boolean,
    val name: String,
    val picture_url: String,
    val slug: String,
    val type: String,
    val user_id: Int
)