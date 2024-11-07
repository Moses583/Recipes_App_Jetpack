package com.ravemaster.recipeappjetpack.di

import com.ravemaster.recipeappjetpack.data.remote.getrecipeslist.GetRecipes
import com.ravemaster.recipeappjetpack.data.remote.gettags.GetTags
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .baseUrl("https://tasty.p.rapidapi.com/")
        .build()

    @Provides
    @Singleton
    fun provideGetRecipesApi(): GetRecipes {
        return retrofit.create(GetRecipes::class.java)
    }

    @Provides
    @Singleton
    fun provideGetTagsApi(): GetTags {
        return retrofit.create(GetTags::class.java)
    }

}