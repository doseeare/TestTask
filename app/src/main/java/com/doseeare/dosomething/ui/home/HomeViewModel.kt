package com.doseeare.dosomething.ui.home

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.doseeare.domain.base.Result
import com.doseeare.domain.model.ActivityModel
import com.doseeare.domain.usecase.ActivityUseCase
import com.doseeare.domain.usecase.HistoryUseCase
import com.doseeare.dosomething.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(
    private val activityUseCase: ActivityUseCase,
    application: Application
) :
    BaseViewModel(application) {
    val error = MutableLiveData<String>()

    val randomActivityResult = MutableLiveData<ActivityModel>()

    fun getRandomActivity() = viewModelScope.launch {
        activityUseCase.getRandomActivity().collect {
            when (it) {
                is Result.Success -> randomActivityResult.postValue(it.successData!!)
                is Result.Failure -> error.postValue("Проблемы с интернетом")
            }
        }
    }

   /* fun insertActivity() = viewModelScope.launch {
        historyUseCase.insertActivityAsHistory(randomActivityResult.value!!)
    }*/

}