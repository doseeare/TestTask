package com.doseeare.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.doseeare.data.local.dao.HistoryDAO
import com.doseeare.data.local.entity.HistoryEntity

@Database(entities = [HistoryEntity::class], version = 1)
abstract class HistoryDataBase : RoomDatabase() {

    abstract fun historyDAO(): HistoryDAO
}