package com.doseeare.dosomething.di

import com.doseeare.domain.usecase.ActivityUseCase
import com.doseeare.domain.usecase.HistoryUseCase
import com.doseeare.dosomething.ui.history.HistoryViewModel
import com.doseeare.dosomething.ui.home.HomeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
    viewModel { HomeViewModel(get(),  androidApplication()) }
    viewModel { HistoryViewModel(get(), androidApplication()) }
}

