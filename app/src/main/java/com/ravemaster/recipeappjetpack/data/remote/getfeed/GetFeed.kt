package com.ravemaster.recipeappjetpack.data.remote.getfeed

import com.ravemaster.recipeappjetpack.data.remote.getfeed.models.FeedsApiResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GetFeed{

    @GET("feeds/list")
    suspend fun getFeeds(
        @Query("size") size: Int,
        @Query("timezone") timeZone: String,
        @Query("vegetarian") veg: Boolean,
        @Query("from") from: Int,
        @Header("x-rapidapi-key") apiKey: String,
        @Header("x-rapidapi-host") host: String,
    ): FeedsApiResponse

}