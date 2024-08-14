package com.rey.palindromecheck.di

import android.content.Context
import com.rey.palindromecheck.data.ActivityRepository
import com.rey.palindromecheck.data.remote.retrofit.ApiConfig

object Injection {
    fun provideRepository(context: Context): ActivityRepository {
        val apiService = ApiConfig.getApiService()
        return ActivityRepository(apiService)
    }
}