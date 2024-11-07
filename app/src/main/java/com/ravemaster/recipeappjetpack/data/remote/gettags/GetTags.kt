package com.ravemaster.recipeappjetpack.data.remote.gettags

import com.ravemaster.recipeappjetpack.data.remote.gettags.models.TagsApiResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface GetTags {

    @GET("tags/list")
    suspend fun getTags(
        @Header("x-rapidapi-key") apiKey: String,
        @Header("x-rapidapi-host") host: String,
    ): TagsApiResponse

}