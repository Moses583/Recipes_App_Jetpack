package com.ravemaster.recipeappjetpack.data.remote

import com.ravemaster.recipeappjetpack.data.remote.models.RecipesListResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GetRecipes {
    @GET("recipes/list")
    suspend fun getRecipes(
        @Query("from") from: Int,
        @Query("size") size: Int,
        @Header("x-rapidapi-key") apiKey: String,
        @Header("x-rapidapi-host") host: String,
    ): RecipesListResponse

    companion object{
        const val BASE_URL = "https://tasty.p.rapidapi.com/"
    }
}