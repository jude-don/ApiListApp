package com.fetch.ApiListApp.presentation.fetch_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fetch.ApiListApp.R
import com.fetch.ApiListApp.common.Resources


@Composable
fun FetchListScreen(
    viewModel: FetchListViewModel = hiltViewModel()
){
    val state = viewModel.state.collectAsState().value

    when(state){
        is Resources.Loading ->{
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ){
                CircularProgressIndicator()
            }

        }
        is Resources.Success ->{

            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                items(state.data ?: emptyList()){
                    item -> Text(
                        text = "List ${item.listId}: ${item.name}",
                        fontSize = dimensionResource(R.dimen.font_size).value.sp,
                        modifier = Modifier
                            .padding(dimensionResource(R.dimen.padding))
                    )
                }
            }
        }

        is Resources.Error -> {
            Text(text = "Error: ${state.message}")
        }
    }
}