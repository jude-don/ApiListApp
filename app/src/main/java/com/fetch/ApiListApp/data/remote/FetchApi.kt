package com.fetch.ApiListApp.data.remote

import com.fetch.ApiListApp.data.FetchListItem
import retrofit2.http.GET

interface FetchApi {
    @GET("hiring.json")
    suspend fun getItems(): List<FetchListItem>
}