package com.example.jetpack_compose_paging3.viewmodel

import android.service.autofill.UserData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.jetpack_compose_paging3.paging.UserSource
import com.example.jetpack_compose_paging3.remote.DataDto
import kotlinx.coroutines.flow.Flow

class UserViewModel: ViewModel() {
    val user:Flow<PagingData<DataDto>> = Pager(PagingConfig(pageSize = 10)) {
        UserSource()
    }.flow.cachedIn(viewModelScope)
}