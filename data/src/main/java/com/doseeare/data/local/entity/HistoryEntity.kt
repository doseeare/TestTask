package com.doseeare.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HistoryEntity(
    @PrimaryKey val key: String,
    val activity: String,
    val accessibility: Double,
    val type: String,
    val participants: Long,
    val price: Double,
    val link: String
)