package com.ravemaster.recipeappjetpack.domain.repository

import com.ravemaster.recipeappjetpack.data.remote.gettags.models.TagsApiResponse
import com.ravemaster.recipeappjetpack.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface TagsRepository {
    suspend fun getTags(): Flow<Resource<TagsApiResponse>>
}