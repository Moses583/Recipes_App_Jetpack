package com.ravemaster.recipeappjetpack.di

import com.ravemaster.recipeappjetpack.data.repository.RecipesListRepositoryImpl
import com.ravemaster.recipeappjetpack.data.repository.TagsRepositoryImpl
import com.ravemaster.recipeappjetpack.domain.repository.RecipesListRepository
import com.ravemaster.recipeappjetpack.domain.repository.TagsRepository
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

    @Binds
    @Singleton
    abstract fun bindsTagsRepository(
        tagsRepositoryImpl: TagsRepositoryImpl
    ): TagsRepository
}