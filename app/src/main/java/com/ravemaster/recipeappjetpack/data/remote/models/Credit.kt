package com.ravemaster.recipeappjetpack.data.remote.models

data class Credit(
    val is_verified: Boolean,
    val name: String,
    val type: String,
    val user_id: Any
)