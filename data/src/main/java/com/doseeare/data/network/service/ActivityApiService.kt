package com.doseeare.data.network.service

import com.doseeare.data.network.response.ActivityResponse
import retrofit2.Response
import retrofit2.http.GET

interface ActivityApiService {
    @GET("activity/")
    suspend fun getActivity(): Response<ActivityResponse>
}