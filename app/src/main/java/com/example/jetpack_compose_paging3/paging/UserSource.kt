package com.example.jetpack_compose_paging3.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.jetpack_compose_paging3.api.ApiClient
import com.example.jetpack_compose_paging3.remote.DataDto
import com.example.jetpack_compose_paging3.remote.UsersDto
import retrofit2.HttpException
import java.io.IOException

class UserSource: PagingSource<Int, DataDto>() {
    override fun getRefreshKey(state: PagingState<Int, DataDto>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataDto> {
        return try {
            val nextPage = params.key ?: 1
            val userList = ApiClient.apiService.getUserList(page = nextPage)
            LoadResult.Page(
                data = userList.data,
                prevKey = if(nextPage == 1) null else nextPage - 1,
                nextKey = if(userList.data.isEmpty()) null else userList.page + 1
            )
        }catch (e: HttpException){
            return LoadResult.Error(e)
        }catch (e: IOException){
            return LoadResult.Error(e)
        }
    }


}