package com.ravemaster.recipeappjetpack.data.repository

import com.ravemaster.recipeappjetpack.data.remote.getfeed.GetFeed
import com.ravemaster.recipeappjetpack.data.remote.getfeed.models.FeedsApiResponse
import com.ravemaster.recipeappjetpack.domain.repository.FeedRepository
import com.ravemaster.recipeappjetpack.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class FeedRepositoryImpl @Inject constructor(
    private val getFeed: GetFeed
) : FeedRepository {
    override suspend fun getFeeds(
        size: Int,
        from: Int
    ): Flow<Resource<FeedsApiResponse>> {
        return flow {
            emit(Resource.Loading(true))

            val feeds = try {
                getFeed.getFeeds(size = size, timeZone = "+0700", veg = false, from = from,
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

            emit(Resource.Success(feeds))
        }
    }
}