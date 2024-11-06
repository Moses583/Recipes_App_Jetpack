package com.ravemaster.recipeappjetpack.di

import com.ravemaster.recipeappjetpack.data.repository.RecipesListRepositoryImpl
import com.ravemaster.recipeappjetpack.domain.repository.RecipesListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsRecipeRepository(
        recipesRepositoryImpl: RecipesListRepositoryImpl
    ): RecipesListRepository

}