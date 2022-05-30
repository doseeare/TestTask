package com.doseeare.domain.di

import com.doseeare.domain.repository.local.HistoryRepository
import com.doseeare.domain.repository.network.ActivityRepository
import com.doseeare.domain.usecase.ActivityUseCase
import com.doseeare.domain.usecase.HistoryUseCase
import org.koin.core.scope.get
import org.koin.dsl.module

val useCaseModules = module {
    factory {
        ActivityUseCase(
            activityRepository = get(),
        )
    }
    factory {
        HistoryUseCase(
            historyRepository = get(),
        )
    }
}