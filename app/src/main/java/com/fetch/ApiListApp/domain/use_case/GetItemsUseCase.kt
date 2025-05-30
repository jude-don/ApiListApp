package com.fetch.ApiListApp.domain.use_case

import com.fetch.ApiListApp.common.Resources
import com.fetch.ApiListApp.data.FetchListItem
import com.fetch.ApiListApp.domain.repository.FetchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(
    private val repository: FetchRepository
) {
    operator fun invoke(): Flow<Resources<List<FetchListItem>>> {
        return repository.getItems()
    }
}