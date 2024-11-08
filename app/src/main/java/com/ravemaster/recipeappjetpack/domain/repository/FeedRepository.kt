package com.ravemaster.recipeappjetpack.domain.repository

import com.ravemaster.recipeappjetpack.data.remote.getfeed.models.FeedsApiResponse
import com.ravemaster.recipeappjetpack.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface FeedRepository {
    suspend fun getFeeds(size: Int,from: Int): Flow<Resource<FeedsApiResponse>>
}