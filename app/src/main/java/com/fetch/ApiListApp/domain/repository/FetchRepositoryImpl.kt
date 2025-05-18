package com.fetch.ApiListApp.domain.repository

import com.fetch.ApiListApp.common.Resources
import com.fetch.ApiListApp.data.FetchListItem
import com.fetch.ApiListApp.data.remote.FetchApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchRepositoryImpl @Inject constructor(
    private val api: FetchApi
): FetchRepository {
    override fun getItems(): Flow<Resources<List<FetchListItem>>> = flow{
        emit(Resources.Loading())
        try {
            val response = api.getItems().filter { !it.name.isNullOrBlank()}.sortedWith(
                compareBy({it.listId}, {it.name})
            )
            emit(Resources.Success(response))
        }catch (e:Exception){
            emit(Resources.Error(e.localizedMessage ?: "Undefined error"))
        }
    }
}