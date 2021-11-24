package com.example.jetpack_compose_paging3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberImagePainter
import com.example.jetpack_compose_paging3.remote.DataDto
import com.example.jetpack_compose_paging3.ui.theme.Jetpackcomposepaging3Theme
import com.example.jetpack_compose_paging3.ui.theme.Purple200
import com.example.jetpack_compose_paging3.viewmodel.UserViewModel
import kotlinx.coroutines.flow.Flow

class MainActivity : ComponentActivity() {
    val viewModel :UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Jetpackcomposepaging3Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    UserList(viewModel)
                }
            }
        }
    }

    @Composable
    private fun UserList(viewModel: UserViewModel) {
        userListDetail(viewModel.user)
    }

    @Composable
    private fun userListDetail(user: Flow<PagingData<DataDto>>) {
        val userListItem: LazyPagingItems<DataDto> = user.collectAsLazyPagingItems()

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Purple200)
                    .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Compose Pagination",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn{
                items(userListItem){item->
                    item?.let {
                        UserListItem(it)
                    }
                }
            }
        }
    }

    @Composable
    fun UserListItem(user: DataDto) {
        Card(
            modifier = Modifier
                .padding(10.dp, 5.dp, 10.dp, 5.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            elevation = 12.dp
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color.White)
            ) {
                Surface(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(12.dp))
                ) {
                    //Coil Image
                    Image(
                        painter = rememberImagePainter("${user.avatar}"),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                }
                Column(
                    modifier = Modifier
                        .align(CenterVertically)
                        .padding(start = 15.dp)
                ) {
                    Text(
                        text = "Name: ${user.first_name} ${user.last_name}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                        )

                    Text(
                        text = "Email: ${user.email}",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        modifier = Modifier.padding(20.dp)
                    )

                }
            }
        }
    }
}

