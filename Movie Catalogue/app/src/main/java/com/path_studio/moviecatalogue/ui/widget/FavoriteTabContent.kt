package com.path_studio.moviecatalogue.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity

@Composable
fun FavMovieTabContentScreen(
    navController: NavController,
    favoriteMovieList: SnapshotStateList<MovieEntity>,
    favoriteMovieAvailability: MutableState<Boolean>,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if(favoriteMovieAvailability.value) {
            if(favoriteMovieList.size > 0){
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    items(favoriteMovieList) { movies ->
                        ItemFavorite(
                            navController = navController,
                            data = movies
                        )
                    }
                }
            }else{
                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.no_data),
                    contentDescription = stringResource(id = R.string.no_data_img),
                    modifier = Modifier.fillMaxWidth(.7f)
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    stringResource(id = R.string.no_data),
                    style = TextStyle (
                        color = Color.Black,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.weight(1f))
            }
        }else{
            NotFoundAnimation(
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}

@Composable
fun FavTvShowTabContentScreen(
    navController: NavController,
    favoriteTvShowList: SnapshotStateList<TvShowEntity>,
    favoriteTvShowAvailability: MutableState<Boolean>,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        if(favoriteTvShowAvailability.value) {
            if(favoriteTvShowList.size > 0){
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    items(favoriteTvShowList) { shows ->
                        ItemFavorite(
                            navController = navController,
                            data = shows
                        )
                    }
                }
            }else{
                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.no_data),
                    contentDescription = stringResource(id = R.string.no_data_img),
                    modifier = Modifier.fillMaxWidth(.7f)
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    stringResource(id = R.string.no_data),
                    style = TextStyle (
                        color = Color.Black,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.weight(1f))
            }
        }else{
            NotFoundAnimation(
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}