package com.path_studio.moviecatalogue.ui.mainPage.tvShow

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.BackdropScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.ui.ui.theme.Purple700
import com.path_studio.moviecatalogue.ui.widget.ItemMovieAndTvShow
import com.path_studio.moviecatalogue.ui.widget.NoConnectionAnimation
import com.path_studio.moviecatalogue.ui.widget.NotFoundAnimation
import com.path_studio.moviecatalogue.util.Utils.isInternetAvailable

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TvShowTab(
    navController: NavController,
    backdropScaffoldState: BackdropScaffoldState,
    tvShows: SnapshotStateList<TvShowEntity>,
    tvShowAvailability: MutableState<Boolean>
) {
    val context = LocalContext.current

    if (tvShowAvailability.value) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    text = stringResource(id = R.string.list_of_tv_shows),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                Icon(
                    imageVector =
                    if (backdropScaffoldState.isConcealed) {
                        Icons.Default.ArrowDropDown
                    } else {
                        Icons.Default.ArrowDropUp
                    },
                    tint = Purple700,
                    contentDescription = stringResource(id = R.string.show_indicator)
                )
            }

            LazyVerticalGrid(
                modifier = Modifier.weight(1f),
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(
                    start = 12.dp,
                    top = 16.dp,
                    end = 12.dp,
                    bottom = 16.dp
                ),
            ) {
                items(tvShows) { tvShow ->
                    ItemMovieAndTvShow(
                        navController = navController,
                        data = tvShow
                    )
                }
            }
        }
    } else {
        if(isInternetAvailable(context)) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NotFoundAnimation(
                    modifier = Modifier
                        .fillMaxWidth(.7f)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Data Not Found",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }else{
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NoConnectionAnimation(
                    modifier = Modifier
                        .fillMaxSize(.7f)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Connection Lost",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }
}