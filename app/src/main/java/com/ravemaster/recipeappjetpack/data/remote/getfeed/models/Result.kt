package com.ravemaster.recipeappjetpack.data.remote.getfeed.models

data class Result(
    val category: String,
    val item: Item,
    val items: List<ItemX>,
    val min_items: Int,
    val name: String,
    val type: String
)