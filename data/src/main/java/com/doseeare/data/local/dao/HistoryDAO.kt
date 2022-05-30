package com.doseeare.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.doseeare.data.local.entity.HistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDAO {

    @Insert
    suspend fun insertHistory(entity: HistoryEntity)

    @Query("SELECT * FROM HistoryEntity")
    suspend fun fetchHistoryAsync(): Flow<List<HistoryEntity>>

}