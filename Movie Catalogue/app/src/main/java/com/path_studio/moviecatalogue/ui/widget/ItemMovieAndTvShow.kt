package com.path_studio.moviecatalogue.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.navigations.TmdbScreen
import com.path_studio.moviecatalogue.util.Utils.changeStringToDateFormat
import com.smarttoolfactory.ratingbar.RatingBar

@Composable
fun ItemMovieAndTvShow(
    navController: NavController,
    data: MovieEntity
){
    val imageBackground = ImageBitmap.imageResource(id = R.drawable.star_background)
    val imageForeground = ImageBitmap.imageResource(id = R.drawable.star_foreground)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(Color.White)
            .clickable {
                navController.navigate(TmdbScreen.DetailMovieScreen.route){
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
                navController.currentBackStackEntry?.arguments?.putLong("movieId", data.movieId)
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(!data.posterPath.isNullOrEmpty() && data.posterPath != "null") {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://image.tmdb.org/t/p/w500/${data.posterPath}")
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_broken_image_black),
                contentDescription = stringResource(R.string.description),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp)
                    .width(100.dp)
            )
        }else{
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1665px-No-Image-Placeholder.svg.png")
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_broken_image_black),
                contentDescription = stringResource(R.string.description),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp)
                    .width(100.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        RatingBar(
            rating = data.voteAverage.toFloat()/2,
            space = 2.dp,
            imageEmpty = imageBackground,
            imageFilled = imageForeground,
            animationEnabled = true,
            gestureEnabled = false,
            itemSize = 20.dp
        )

        Text(
            text = data.title,
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = data.releaseDate?.let { changeStringToDateFormat(it) } ?: "Unknown release date",
            style = TextStyle(
                color = Color.Gray,
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            ),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun ItemMovieAndTvShow(
    navController: NavController,
    data: TvShowEntity
){
    val imageBackground = ImageBitmap.imageResource(id = R.drawable.star_background)
    val imageForeground = ImageBitmap.imageResource(id = R.drawable.star_foreground)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(Color.White)
            .clickable {
                navController.navigate(TmdbScreen.DetailTvShowScreen.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
                navController.currentBackStackEntry?.arguments?.putLong("tvShowId", data.tvShowId)
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(!data.posterPath.isNullOrEmpty() && data.posterPath != "null") {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://image.tmdb.org/t/p/w500/${data.posterPath}")
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_broken_image_black),
                contentDescription = stringResource(R.string.description),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp)
                    .width(100.dp)
            )
        }else{
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1665px-No-Image-Placeholder.svg.png")
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_broken_image_black),
                contentDescription = stringResource(R.string.description),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp)
                    .width(100.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        val ratingValue = if( data.voteAverage != null){
            data.voteAverage!!.toFloat()/2
        }else{
            0.0
        }
        RatingBar(
            rating = ratingValue.toFloat(),
            space = 2.dp,
            imageEmpty = imageBackground,
            imageFilled = imageForeground,
            animationEnabled = true,
            gestureEnabled = false,
            itemSize = 20.dp
        )

        Text(
            text = data.name,
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = data.firstAirDate?.let { changeStringToDateFormat(it) } ?: "Unknown first air date",
            style = TextStyle(
                color = Color.Gray,
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            ),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}