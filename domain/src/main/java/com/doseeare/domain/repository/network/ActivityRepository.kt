package com.doseeare.domain.repository.network

import com.doseeare.domain.base.Error
import com.doseeare.domain.base.Result
import com.doseeare.domain.model.ActivityModel
import kotlinx.coroutines.flow.Flow

interface ActivityRepository {
    suspend fun getRandomActivity(): Flow<Result<ActivityModel, Error>>
}