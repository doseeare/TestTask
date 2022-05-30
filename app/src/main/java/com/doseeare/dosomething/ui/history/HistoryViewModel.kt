package com.doseeare.dosomething.ui.history

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.doseeare.domain.usecase.ActivityUseCase
import com.doseeare.domain.usecase.HistoryUseCase
import com.doseeare.dosomething.base.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class HistoryViewModel(
    private val activityUseCase: ActivityUseCase,
    app: Application
) : BaseViewModel(app), KoinComponent {

}