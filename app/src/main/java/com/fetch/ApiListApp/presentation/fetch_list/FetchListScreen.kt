package com.fetch.ApiListApp.presentation.fetch_list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fetch.ApiListApp.common.Resources


@Composable
fun FetchListScreen(
    viewModel: FetchListViewModel = hiltViewModel()
){
    val state = viewModel.state.collectAsState().value

    when(state){
        is Resources.Loading ->{
            CircularProgressIndicator()
        }
        is Resources.Success ->{
            LazyColumn {
                items(state.data ?: emptyList()){
                    item -> Text(
                        text = "List ${item.listId}: ${item.name}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
            }
        }

        is Resources.Error -> {
            Text(text = "Error: ${state.message}")
        }
    }
}