package com.ravemaster.recipeappjetpack.data.remote.getrecipeslist

import com.ravemaster.recipeappjetpack.data.remote.getrecipeslist.models.RecipesListResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GetRecipes {
    @GET("recipes/list")
    suspend fun getRecipes(
        @Query("from") from: Int,
        @Query("size") size: Int,
        @Query("tags") tags: String,
        @Header("x-rapidapi-key") apiKey: String,
        @Header("x-rapidapi-host") host: String,
    ): RecipesListResponse
}