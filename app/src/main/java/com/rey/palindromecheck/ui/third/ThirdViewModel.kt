package com.rey.palindromecheck.ui.third

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.rey.palindromecheck.data.ActivityRepository
import com.rey.palindromecheck.data.remote.retrofit.response.DataItem
import com.rey.palindromecheck.di.Injection

class ThirdViewModel(activityRepository: ActivityRepository) : ViewModel() {

    val quote: LiveData<PagingData<DataItem>> =
        activityRepository.getUsers().cachedIn(viewModelScope)

}
