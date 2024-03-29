package com.path_studio.moviecatalogue.ui.mainPage

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.helper.BackPress
import com.path_studio.moviecatalogue.navigations.TmdbScreen
import com.path_studio.moviecatalogue.navigations.bottomNav.BottomNavItem
import com.path_studio.moviecatalogue.ui.mainPage.favorite.FavoriteTab
import com.path_studio.moviecatalogue.ui.mainPage.favorite.viewModel.FavoriteMovieViewModel
import com.path_studio.moviecatalogue.ui.mainPage.favorite.viewModel.FavoriteTvShowViewModel
import com.path_studio.moviecatalogue.ui.mainPage.movie.MovieTab
import com.path_studio.moviecatalogue.ui.mainPage.movie.MovieViewModel
import com.path_studio.moviecatalogue.ui.mainPage.tvShow.TvShowTab
import com.path_studio.moviecatalogue.ui.mainPage.tvShow.TvShowViewModel
import com.path_studio.moviecatalogue.ui.ui.theme.Purple900
import com.path_studio.moviecatalogue.ui.ui.theme.Teal700
import com.path_studio.moviecatalogue.ui.widget.Loader
import com.path_studio.moviecatalogue.util.Utils.OnLifecycleEvent
import com.path_studio.moviecatalogue.vo.Status
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

private lateinit var movieViewModel: MovieViewModel
private lateinit var tvShowViewModel: TvShowViewModel
private lateinit var favoriteMovieViewModel: FavoriteMovieViewModel
private lateinit var favoriteTvShowViewModel: FavoriteTvShowViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(
    navController: NavController
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    movieViewModel = koinViewModel()
    tvShowViewModel = koinViewModel()
    favoriteMovieViewModel = koinViewModel()
    favoriteTvShowViewModel = koinViewModel()

    val backdropScaffoldState = rememberBackdropScaffoldState(
        BackdropValue.Concealed
    )

    val isLoading = remember { mutableStateOf(true) }

    val movieList = remember {
        mutableStateListOf<MovieEntity>()
    }
    val movieAvailability = remember { mutableStateOf(false) }

    val tvShowList = remember {
        mutableStateListOf<TvShowEntity>()
    }
    val tvShowAvailability = remember { mutableStateOf(false) }

    val favoriteMovieList = remember {
        mutableStateListOf<MovieEntity>()
    }
    val favoriteMovieAvailability = remember { mutableStateOf(false) }

    val favoriteTvShowList = remember {
        mutableStateListOf<TvShowEntity>()
    }
    val favoriteTvShowAvailability = remember { mutableStateOf(false) }

    //bottomNavigation
    val currentBottomTab = rememberSaveable { mutableStateOf(0) }
    val bottomNavItems = listOf(
        BottomNavItem.ListMovie,
        BottomNavItem.Favorites,
        BottomNavItem.ListTvShow
    )

    //Back press exit attributes
    var showToast by remember { mutableStateOf(false) }
    var backPressState by remember { mutableStateOf<BackPress>(BackPress.Idle) }
    if(showToast){
        Toast.makeText(context, "Press again to exit", Toast.LENGTH_SHORT).show()
        showToast= false
    }

    LaunchedEffect(key1 = backPressState) {
        if (backPressState == BackPress.InitialTouch) {
            delay(2000)
            backPressState = BackPress.Idle
        }
    }

    BackHandler(backPressState == BackPress.Idle) {
        backPressState = BackPress.InitialTouch
        showToast = true
    }

    OnLifecycle(
        movieList = movieList,
        tvShowList = tvShowList,
        favoriteMovieList = favoriteMovieList,
        favoriteTvShowList = favoriteTvShowList,
        lifecycleOwner = lifecycleOwner,
        isLoading = isLoading,
        movieAvailability = movieAvailability,
        tvShowAvailability = tvShowAvailability,
        favoriteMovieAvailability = favoriteMovieAvailability,
        favoriteTvShowAvailability = favoriteTvShowAvailability
    )

    //View Section
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
                Image(
                    painter = painterResource(id = R.drawable.home_banner),
                    contentDescription = "Home Background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )

                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.tmdb),
                            contentDescription = stringResource(id = R.string.app_logo),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth(.4f)
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        IconButton(
                            onClick = {
                                navController.navigate(TmdbScreen.SearchScreen.route)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search Icon"
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Column(
                        modifier = Modifier.padding(24.dp)
                    ) {
                        Text(
                            stringResource(id = R.string.welcome),
                            style = TextStyle (
                                color = Color.White,
                                fontSize = 34.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            stringResource(id = R.string.welcome_details),
                            style = TextStyle (
                                color = Color.White,
                                fontSize = 16.sp,
                            )
                        )
                    }
                }

            }
        },
        frontLayerContent = {
            if(isLoading.value){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ){
                    Loader(
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }else {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        when (currentBottomTab.value) {
                            0 -> {
                                MovieTab(
                                    navController = navController,
                                    backdropScaffoldState = backdropScaffoldState,
                                    movies = movieList,
                                    movieAvailability = movieAvailability
                                )
                            }
                            1 -> {
                                FavoriteTab(
                                    navController = navController,
                                    backdropScaffoldState = backdropScaffoldState,
                                    favoriteMovieList = favoriteMovieList,
                                    favoriteTvShowList = favoriteTvShowList,
                                    favoriteMovieAvailability = favoriteMovieAvailability,
                                    favoriteTvShowAvailability = favoriteTvShowAvailability
                                )
                            }
                            2 -> {
                                TvShowTab(
                                    navController = navController,
                                    backdropScaffoldState = backdropScaffoldState,
                                    tvShows = tvShowList,
                                    tvShowAvailability = tvShowAvailability
                                )
                            }
                        }
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        bottomNavItems.forEach { item ->
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .background(Color.White)
                                    .clickable {
                                        currentBottomTab.value = item.index
                                    },
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.title,
                                    modifier = Modifier.size(24.dp),
                                    tint = if (currentBottomTab.value == item.index) {
                                        Purple900
                                    } else {
                                        Color.Gray
                                    }
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = item.title,
                                    style = TextStyle(
                                        color = if (currentBottomTab.value == item.index) {
                                            Purple900
                                        } else {
                                            Color.Gray
                                        },
                                        fontSize = 11.sp
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}

@Composable
private fun OnLifecycle(
    movieList: SnapshotStateList<MovieEntity>,
    tvShowList: SnapshotStateList<TvShowEntity>,
    favoriteMovieList: SnapshotStateList<MovieEntity>,
    favoriteTvShowList: SnapshotStateList<TvShowEntity>,
    lifecycleOwner: LifecycleOwner,
    isLoading: MutableState<Boolean>,
    movieAvailability: MutableState<Boolean>,
    favoriteMovieAvailability: MutableState<Boolean>,
    tvShowAvailability: MutableState<Boolean>,
    favoriteTvShowAvailability: MutableState<Boolean>
) {
    OnLifecycleEvent { _, event ->
        // do stuff on event
        when (event) {
            Lifecycle.Event.ON_RESUME -> {
                isLoading.value = true

                movieAvailability.value = false
                tvShowAvailability.value = false
                favoriteMovieAvailability.value = false
                favoriteTvShowAvailability.value = false

                //Clear all list first
                movieList.clear()
                tvShowList.clear()
                favoriteMovieList.clear()
                favoriteTvShowList.clear()

                movieViewModel.getDiscoverMovies().observe(lifecycleOwner) { movies ->
                    if (movies != null) {
                        when (movies.status) {
                            Status.LOADING -> movieAvailability.value = true
                            Status.SUCCESS -> {
                                movies.data?.forEach {
                                    movieList.add(it)
                                }
                                movieAvailability.value = true
                                isLoading.value = false
                            }
                            Status.ERROR -> {
                                movieAvailability.value = false
                                isLoading.value = false
                            }
                        }
                    }
                }

                tvShowViewModel.getDiscoverTvShow().observe(lifecycleOwner) { tvShow ->
                    if (tvShow != null) {
                        when (tvShow.status) {
                            Status.LOADING -> tvShowAvailability.value = true
                            Status.SUCCESS -> {
                                tvShow.data?.forEach {
                                    tvShowList.add(it)
                                }
                                tvShowAvailability.value = true
                                isLoading.value = false
                            }
                            Status.ERROR -> {
                                tvShowAvailability.value = false
                                isLoading.value = false
                            }
                        }
                    }
                }

                favoriteMovieViewModel.getMovieFav().observe(lifecycleOwner) { movies ->
                    favoriteMovieAvailability.value = true
                    movies.forEach {
                        favoriteMovieList.add(it)
                    }
                }

                favoriteTvShowViewModel.getTvShowFav().observe(lifecycleOwner) { shows ->
                    favoriteTvShowAvailability.value = true
                    shows.forEach {
                        favoriteTvShowList.add(it)
                    }
                }
            }
            else -> { /* other stuff */ }
        }
    }
}