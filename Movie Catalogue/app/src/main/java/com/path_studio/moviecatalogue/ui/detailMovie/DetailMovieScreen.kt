package com.path_studio.moviecatalogue.ui.detailMovie

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.data.entities.Movie
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.ui.ui.theme.Teal700
import com.path_studio.moviecatalogue.util.Utils
import com.path_studio.moviecatalogue.vo.Status
import org.koin.androidx.compose.koinViewModel

private lateinit var detailMovieViewModel: DetailMovieViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailMovieScreen(
    navController: NavController,
    data: Movie?
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val backdropScaffoldState = rememberBackdropScaffoldState(
        BackdropValue.Concealed
    )

    detailMovieViewModel = koinViewModel()

    val detailMovie = remember { mutableStateOf(Movie()) }
    val detailMovieAvailability = remember { mutableStateOf(false) }
    val isLoading = remember { mutableStateOf(false) }

    OnLifecycle(
        detailMovie = detailMovie,
        lifecycleOwner = lifecycleOwner,
        isLoading = isLoading,
        detailMovieAvailability = detailMovieAvailability,
        movieId = data?.movieId
    )

    //View Section
    if (data != null){
        BackdropScaffold(
            scaffoldState = backdropScaffoldState,
            peekHeight = (LocalConfiguration.current.screenHeightDp * 0.15).dp,
            headerHeight = (LocalConfiguration.current.screenHeightDp * 0.6).dp,
            gesturesEnabled = true,
            appBar = {},
            modifier = Modifier
                .background(Teal700),
            backLayerContent = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://www.themoviedb.org/t/p/w533_and_h300_bestv2${detailMovie.value.backdropPath}")
                            .crossfade(true)
                            .build(),
                        placeholder = painterResource(R.drawable.ic_broken_image_black),
                        contentDescription = stringResource(R.string.description),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            },
            frontLayerContent = {

            }
        )
    }else{
        //EMPTY DATA INFO
    }

}

@Composable
private fun OnLifecycle(
    detailMovie: MutableState<Movie>,
    lifecycleOwner: LifecycleOwner,
    isLoading: MutableState<Boolean>,
    detailMovieAvailability: MutableState<Boolean>,
    movieId: Long?
) {
    Utils.OnLifecycleEvent { _, event ->
        // do stuff on event
        when (event) {
            Lifecycle.Event.ON_RESUME -> {
                isLoading.value = true
                detailMovieAvailability.value = false

                //Clear all list first
                detailMovie.value = Movie()

                detailMovieViewModel.getDetailMovie(movieId.toString()).observe(lifecycleOwner) { movie ->
                    if (movie != null) {
                        when (movie.status) {
                            Status.LOADING -> detailMovieAvailability.value = false
                            Status.SUCCESS -> {
                                detailMovieAvailability.value = true

                                val data = movie.data!!
                                detailMovie.value = Movie(
                                    movieId = data.movieId,
                                    title = data.title,
                                    overview = data.overview,
                                    posterPath = data.posterPath,
                                    backdropPath = data.backdropPath,
                                    releaseDate = data.releaseDate,
                                    voteAverage = data.voteAverage,
                                    genres = data.genres,
                                    runtime = data.runtime,
                                    favorite = data.favorite
                                )
                            }
                            Status.ERROR -> {
                                detailMovieAvailability.value = false
                            }
                        }
                    }
                }
            }
            else -> { /* other stuff */
            }
        }
    }
}