package com.doseeare.data.di

import androidx.room.Room
import com.doseeare.data.local.HistoryDataBase
import com.doseeare.data.local.repository.impl.HistoryRepositoryImpl
import com.doseeare.data.network.repository.impl.ActivityRepositoryImpl
import com.doseeare.data.network.service.ActivityApiService
import com.doseeare.domain.repository.local.HistoryRepository
import com.doseeare.domain.repository.network.ActivityRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val repositoryModules = module {
    //don't touch "as SomeRepository"
    single { ActivityRepositoryImpl(get()) as ActivityRepository }
    single { HistoryRepositoryImpl(get()) as HistoryRepository}
}

val networkModules = module {
    single { createOkHttpClient() }
    single {
        createWebService<ActivityApiService>(
            get()
        )
    }
}

val localModule = module {
    single {
        Room.databaseBuilder(androidApplication(), HistoryDataBase::class.java, "HISTORY_DB")
            .build()
    }
    single { get<HistoryDataBase>().historyDAO() }
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient): T {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.boredapi.com/api/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(T::class.java)
}

