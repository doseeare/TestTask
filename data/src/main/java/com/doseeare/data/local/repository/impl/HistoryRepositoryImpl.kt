package com.doseeare.data.local.repository.impl

import com.doseeare.data.local.dao.HistoryDAO
import com.doseeare.data.local.entity.HistoryEntity
import com.doseeare.domain.model.ActivityModel
import com.doseeare.domain.repository.local.HistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HistoryRepositoryImpl(private val historyDAO: HistoryDAO) : HistoryRepository {
    override suspend fun fetchHistory(): Flow<List<ActivityModel>> {
        return historyDAO.fetchHistoryAsync().map { value: List<HistoryEntity> ->
            value.map { historyEntity ->
                ActivityModel(
                    activity = historyEntity.activity,
                    accessibility = historyEntity.accessibility,
                    type = historyEntity.type,
                    participants = historyEntity.participants,
                    price = historyEntity.price,
                    key = historyEntity.key,
                    link = historyEntity.link
                )
            }
        }
    }

    override suspend fun insertHistory(activityModel: ActivityModel) {
        val entity = HistoryEntity(
            activity = activityModel.activity,
            accessibility = activityModel.accessibility,
            type = activityModel.type,
            participants = activityModel.participants,
            price = activityModel.price,
            key = activityModel.key,
            link = activityModel.link
        )
        historyDAO.insertHistory(entity)
    }
}