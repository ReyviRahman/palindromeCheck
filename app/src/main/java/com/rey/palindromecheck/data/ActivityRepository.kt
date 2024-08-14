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
                pageSize = 5
            ),
            pagingSourceFactory = {
                UserPagingSource(apiService)
            }
        ).liveData
    }
}