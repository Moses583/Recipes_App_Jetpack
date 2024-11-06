package com.ravemaster.recipeappjetpack.domain.repository

import com.ravemaster.recipeappjetpack.data.remote.models.RecipesListResponse
import com.ravemaster.recipeappjetpack.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface RecipesListRepository {
    suspend fun getRecipes(from: Int, size: Int): Flow<Resource<RecipesListResponse>>
}