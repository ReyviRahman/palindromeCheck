package com.rey.palindromecheck.data

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.rey.palindromecheck.data.remote.retrofit.ApiService
import com.rey.palindromecheck.data.remote.retrofit.response.DataItem

class ActivityRepository(private val apiService: ApiService) {
    fun getUsers(): LiveData<PagingData<DataItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5,
                enablePlaceholders = false,
                initialLoadSize = 5
            ),
            pagingSourceFactory = {
                UserPagingSource(apiService)
            }
        ).liveData
    }

    companion object {
        @Volatile
        private var instance: ActivityRepository? = null
        fun getInstance(
            apiService: ApiService,
        ): ActivityRepository =
            instance ?: synchronized(this) {
                instance ?: ActivityRepository(apiService)
            }.also { instance = it }
    }
}