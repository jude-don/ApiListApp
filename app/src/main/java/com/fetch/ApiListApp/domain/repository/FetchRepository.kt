package com.fetch.ApiListApp.domain.repository

import com.fetch.ApiListApp.common.Resources
import com.fetch.ApiListApp.data.FetchListItem
import kotlinx.coroutines.flow.Flow

interface FetchRepository {
    fun getItems(): Flow<Resources<List<FetchListItem>>>
}