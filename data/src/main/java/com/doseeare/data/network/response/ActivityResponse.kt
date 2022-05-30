package com.doseeare.data.network.response

import com.doseeare.domain.model.ActivityModel

data class ActivityResponse(
    val activity: String,
    val accessibility: Double,
    val type: String,
    val participants: Long,
    val price: Double,
    val link: String,
    val key: String
) {
    companion object {
        fun ActivityResponse.toModel(): ActivityModel {
            return ActivityModel(
                activity = activity,
                accessibility = accessibility,
                type = type,
                participants = participants,
                price = price,
                link = link,
                key = key
            )
        }
    }
}