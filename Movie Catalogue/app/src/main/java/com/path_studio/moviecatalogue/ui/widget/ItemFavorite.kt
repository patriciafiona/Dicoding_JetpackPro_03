package com.path_studio.moviecatalogue.ui.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
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
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.navigations.TmdbScreen
import com.path_studio.moviecatalogue.util.Utils
import com.smarttoolfactory.ratingbar.RatingBar

@Composable
fun ItemFavorite(
    navController: NavController,
    data: MovieEntity
){
    val imageBackground = ImageBitmap.imageResource(id = R.drawable.star_background)
    val imageForeground = ImageBitmap.imageResource(id = R.drawable.star_foreground)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                navController.navigate(TmdbScreen.DetailMovieScreen.route)
                navController.currentBackStackEntry?.arguments?.putLong("movieId", data.movieId)
            },
        colors = CardDefaults.cardColors(
            containerColor =  Color.White,
        ),
    ) {
        Row {
            if(data.posterPath != null && data.posterPath != "null") {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://image.tmdb.org/t/p/w500/${data.posterPath}")
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_broken_image_black),
                    contentDescription = stringResource(R.string.description),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(130.dp)
                        .width(90.dp)
                        .padding(10.dp)
                )
            }else {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1665px-No-Image-Placeholder.svg.png")
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_broken_image_black),
                    contentDescription = stringResource(R.string.description),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(130.dp)
                        .width(90.dp)
                        .padding(10.dp)
                )
            }

            Spacer(modifier = Modifier.width(5.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = data.title,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(5.dp))

                RatingBar(
                    rating = data.voteAverage.toFloat()/2,
                    space = 2.dp,
                    imageEmpty = imageBackground,
                    imageFilled = imageForeground,
                    animationEnabled = true,
                    gestureEnabled = false,
                    itemSize = 15.dp
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = if(data.releaseDate == null || data.releaseDate == "") {
                        "Unknown release date"
                    }else{
                        data.releaseDate.let { Utils.changeStringToDateFormat(it!!) }
                    },
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 12.sp,
                        textAlign = TextAlign.End
                    )
                )
            }
        }
    }
}

@Composable
fun ItemFavorite(
    navController: NavController,
    data: TvShowEntity
){
    val imageBackground = ImageBitmap.imageResource(id = R.drawable.star_background)
    val imageForeground = ImageBitmap.imageResource(id = R.drawable.star_foreground)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                navController.navigate(TmdbScreen.DetailTvShowScreen.route)
                navController.currentBackStackEntry?.arguments?.putLong("tvShowId", data.tvShowId)
            },
        colors = CardDefaults.cardColors(
            containerColor =  Color.White,
        ),
    ) {
        Row {
            if(data.posterPath != null && data.posterPath != "null") {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://image.tmdb.org/t/p/w500/${data.posterPath}")
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_broken_image_black),
                    contentDescription = stringResource(R.string.description),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(130.dp)
                        .width(90.dp)
                        .padding(10.dp)
                )
            }else {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1665px-No-Image-Placeholder.svg.png")
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_broken_image_black),
                    contentDescription = stringResource(R.string.description),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(130.dp)
                        .width(90.dp)
                        .padding(10.dp)
                )
            }

            Spacer(modifier = Modifier.width(5.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = data.name,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(5.dp))

                RatingBar(
                    rating = (data.voteAverage?.toFloat() ?: 0F) /2,
                    space = 2.dp,
                    imageEmpty = imageBackground,
                    imageFilled = imageForeground,
                    animationEnabled = true,
                    gestureEnabled = false,
                    itemSize = 15.dp
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = if(data.firstAirDate == null || data.firstAirDate == "") {
                            "Unknown first air date"
                        }else{
                            data.firstAirDate.let { Utils.changeStringToDateFormat(it) }
                     },
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 12.sp,
                        textAlign = TextAlign.End
                    )
                )
            }
        }
    }
}