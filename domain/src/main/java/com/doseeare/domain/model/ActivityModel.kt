package com.doseeare.domain.model

data class ActivityModel (
    val activity: String,
    val accessibility: Double,
    val type: String,
    val participants: Long,
    val price: Double,
    val link: String,
    val key: String
)