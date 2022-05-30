package com.doseeare.data.network.repository.impl

import com.doseeare.data.network.response.ActivityResponse.Companion.toModel
import com.doseeare.data.network.service.ActivityApiService
import com.doseeare.domain.base.Error
import com.doseeare.domain.base.Result
import com.doseeare.domain.model.ActivityModel
import com.doseeare.domain.repository.network.ActivityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ActivityRepositoryImpl(private val activityService: ActivityApiService) : ActivityRepository {
    override suspend fun getRandomActivity(): Flow<Result<ActivityModel, Error>> =
        flow {
            try {
                val response = activityService.getActivity()
                if (response.isSuccessful && response.body() != null) {
                    emit(Result.Success(response.body()!!.toModel()))
                } else {
                    emit(Result.Failure(Error.RESPONSE))
                }
            } catch (e: Exception) {
                emit(Result.Failure(Error.NETWORK))
            }
        }
}