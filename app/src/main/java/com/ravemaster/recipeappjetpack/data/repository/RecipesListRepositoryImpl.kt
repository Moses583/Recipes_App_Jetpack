package com.ravemaster.recipeappjetpack.data.repository

import com.ravemaster.recipeappjetpack.data.remote.GetRecipes
import com.ravemaster.recipeappjetpack.data.remote.models.RecipesListResponse
import com.ravemaster.recipeappjetpack.domain.repository.RecipesListRepository
import com.ravemaster.recipeappjetpack.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class RecipesListRepositoryImpl @Inject constructor(
    private val getRecipes: GetRecipes
) : RecipesListRepository {
    override suspend fun getRecipes(from: Int, size: Int): Flow<Resource<RecipesListResponse>> {
        return flow {

            emit(Resource.Loading(true))

            val recipes = try {
                getRecipes.getRecipes(from = from, size = size,
                    "7a9a8d4846mshcfaa4b403a596e8p1d45b5jsneca71b63bb58","tasty.p.rapidapi.com")
            }catch (e: IOException){
                e.printStackTrace()
                emit(Resource.Error(" IOException"))
                return@flow
            } catch (e: HttpException){
                e.printStackTrace()
                emit(Resource.Error("HttpException ${e.code()}"))
                return@flow
            } catch (e: Exception){
                e.printStackTrace()
                emit(Resource.Error("General exception"))
                return@flow
            }

            emit(Resource.Success(recipes))

        }
    }

}