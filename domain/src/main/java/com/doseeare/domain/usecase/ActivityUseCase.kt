package com.doseeare.domain.usecase

import com.doseeare.domain.repository.network.ActivityRepository

class ActivityUseCase(
    private val activityRepository: ActivityRepository,
) {
    suspend fun getRandomActivity() = activityRepository.getRandomActivity()

}