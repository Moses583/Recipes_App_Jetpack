package com.ravemaster.recipeappjetpack.data.remote.getfeed.models

data class Instruction(
    val appliance: Any,
    val display_text: String,
    val end_time: Int,
    val hacks: List<Hack>,
    val id: Int,
    val position: Int,
    val start_time: Int,
    val temperature: Any
)