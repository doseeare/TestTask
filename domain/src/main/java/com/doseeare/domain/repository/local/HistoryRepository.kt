package com.doseeare.domain.repository.local

import com.doseeare.domain.model.ActivityModel
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {
    suspend fun fetchHistory() : Flow<List<ActivityModel>>

    suspend fun insertHistory (activityModel: ActivityModel)
}