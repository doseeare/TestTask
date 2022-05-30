package com.doseeare.dosomething

import android.app.Application
import com.doseeare.data.di.localModule
import com.doseeare.data.di.networkModules
import com.doseeare.data.di.repositoryModules
import com.doseeare.domain.di.useCaseModules
import com.doseeare.dosomething.di.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                repositoryModules +
                        useCaseModules + networkModules
                        + localModule + viewModels
            )
        }
    }
}