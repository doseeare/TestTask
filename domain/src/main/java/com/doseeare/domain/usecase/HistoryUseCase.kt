package com.doseeare.domain.usecase

import com.doseeare.domain.model.ActivityModel
import com.doseeare.domain.repository.local.HistoryRepository

class HistoryUseCase(private val historyRepository: HistoryRepository) {
    suspend fun insertActivityAsHistory(activityModel: ActivityModel) =
        historyRepository.insertHistory(activityModel)
}