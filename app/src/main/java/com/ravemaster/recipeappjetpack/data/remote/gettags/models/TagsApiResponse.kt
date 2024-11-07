package com.ravemaster.recipeappjetpack.data.remote.gettags.models

data class TagsApiResponse(
    val count: Int,
    val next: Any,
    val prev: Any,
    val results: List<Result>
)