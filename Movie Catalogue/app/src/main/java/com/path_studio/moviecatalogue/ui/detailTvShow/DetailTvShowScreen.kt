package com.path_studio.moviecatalogue.ui.detailTvShow

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.ui.ui.theme.*
import com.path_studio.moviecatalogue.ui.widget.*
import com.path_studio.moviecatalogue.util.Utils
import com.path_studio.moviecatalogue.vo.Status
import com.smarttoolfactory.ratingbar.RatingBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.json.JSONArray
import org.koin.androidx.compose.koinViewModel
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.data.source.local.enitity.SeasonEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity

private lateinit var detailTvShowViewModel: DetailTvShowViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailTvShowScreen(
    navController: NavController,
    tvShowId: Long?
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val backdropScaffoldState = rememberBackdropScaffoldState(
        BackdropValue.Concealed
    )

    detailTvShowViewModel = koinViewModel()

    val detailShow = remember { mutableStateOf(TvShowEntity()) }
    val seasons = remember { mutableStateListOf(SeasonEntity()) }
    val detailShowAvailability = remember { mutableStateOf(false) }
    val isLoading = remember { mutableStateOf(true) }

    OnLifecycle(
        detailShow = detailShow,
        seasons = seasons,
        lifecycleOwner = lifecycleOwner,
        isLoading = isLoading,
        detailShowAvailability = detailShowAvailability,
        tvShowId = tvShowId
    )

    //View Section
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
        if (detailShowAvailability.value) {
            BackdropScaffold(
                scaffoldState = backdropScaffoldState,
                peekHeight = (LocalConfiguration.current.screenHeightDp * 0.3).dp,
                headerHeight = (LocalConfiguration.current.screenHeightDp * 0.55).dp,
                gesturesEnabled = false,
                appBar = {},
                modifier = Modifier
                    .background(Purple900),
                backLayerContent = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data("https://www.themoviedb.org/t/p/w533_and_h300_bestv2${detailShow.value.backdropPath}")
                                .crossfade(true)
                                .build(),
                            placeholder = painterResource(R.drawable.ic_broken_image_black),
                            contentDescription = stringResource(R.string.description),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .drawWithCache {
                                    val gradient = Brush.verticalGradient(
                                        colors = listOf(Purple200, Purple500, Purple900),
                                        startY = size.height / 3,
                                        endY = size.height
                                    )
                                    onDrawWithContent {
                                        drawContent()
                                        drawRect(gradient, blendMode = BlendMode.Multiply)
                                    }
                                }
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            IconButton(
                                onClick = {
                                    navController.navigateUp()
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = stringResource(id = R.string.button_back)
                                )
                            }

                            Text(
                                text = stringResource(id = R.string.back),
                                style = TextStyle(
                                    color = Color.White,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                },
                frontLayerContent = {
                    MainContent(
                        detailShow = detailShow,
                        seasons = seasons,
                        context = context
                    )
                }
            )
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NotFoundAnimation(
                    modifier = Modifier
                        .fillMaxSize()
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
        }
    }

}

@Composable
fun MainContent(
    detailShow: MutableState<TvShowEntity>,
    context: Context,
    seasons: SnapshotStateList<SeasonEntity>,
) {
    val data = detailShow.value
    val currentFavState = remember{ mutableStateOf(false) }
    currentFavState.value = data.favorite

    val imageBackground = ImageBitmap.imageResource(id = R.drawable.star_background)
    val imageForeground = ImageBitmap.imageResource(id = R.drawable.star_foreground)

    val listGenre = ArrayList<String>()
    if(data.genres != null) {
        val jArray = JSONArray(data.genres)
        for (i in 0 until jArray.length()) {
            listGenre.add(jArray.getString(i))
        }
    }

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://image.tmdb.org/t/p/w500/${data.posterPath}")
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(com.path_studio.moviecatalogue.R.drawable.ic_broken_image_black),
                contentDescription = stringResource(com.path_studio.moviecatalogue.R.string.poster_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(100.dp)
                    .height(150.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    data.name,
                    style = TextStyle (
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = data.firstAirDate?.let { Utils.changeStringToDateFormat(it) } ?: "Unknown first air date",
                        style = TextStyle(
                            color = Color.Gray,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center
                        ),
                        maxLines = 1,
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(
                        imageVector = Icons.Default.Circle,
                        contentDescription = stringResource(id = com.path_studio.moviecatalogue.R.string.icon_dot),
                        tint = Color.Gray,
                        modifier = Modifier.size(10.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = data.runtime?.let { Utils.changeMinuteToDurationFormat(it) } ?: "Unknown runtime duration",
                        style = TextStyle(
                            color = Color.Gray,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center
                        ),
                        maxLines = 1,
                    )
                }
                RatingBar(
                    rating = (data.voteAverage?.toFloat() ?: 0f) /2,
                    space = 2.dp,
                    imageEmpty = imageBackground,
                    imageFilled = imageForeground,
                    animationEnabled = true,
                    gestureEnabled = false,
                    itemSize = 15.dp
                )

                Row {
                    Spacer(modifier = Modifier.weight(1f))

                    Button(
                        onClick = {
                            detailTvShowViewModel.setFavorite()
                            currentFavState.value = !currentFavState.value
                            setFavStatusToast(currentFavState.value, context = context)
                        },
                        modifier= Modifier.size(40.dp),
                        shape = CircleShape,
                        border= BorderStroke(1.dp, Purple700),
                        contentPadding = PaddingValues(0.dp),
                        colors = ButtonDefaults.buttonColors(contentColor =  Color.White)
                    ) {
                        Icon(
                            if(currentFavState.value) { Icons.Default.Favorite } else { Icons.Default.FavoriteBorder },
                            tint = if(currentFavState.value) { Color.Red } else { Color.White },
                            contentDescription = "content description"
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        TitleSection(
            title = stringResource(id = R.string.information)
        )

        Spacer(modifier = Modifier.height(5.dp))
        if(listGenre.size != 0){
            LazyRow {
                items(listGenre) {
                    ItemGenre(genre = it)
                }
            }
        }else{
            Text(
                text = "No genres information",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                )
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        TitleSection(
            title = stringResource(id = R.string.sinopsis)
        )

        Spacer(modifier = Modifier.height(5.dp))
        if(data.overview != "") {
            data.overview?.let {
                ExpandableText(
                    text = it,
                    modifier = Modifier
                        .padding(horizontal = 10.dp),
                    minimizedMaxLines = 3
                )
            }
        }else{
            Text(
                text = "No sinopsis found"
            )
        }

        if(seasons.size > 0) {
            Spacer(modifier = Modifier.height(10.dp))
            TitleSection(
                title = stringResource(id = R.string.season)
            )

            Spacer(modifier = Modifier.height(5.dp))

            LazyColumn (
                modifier = Modifier.height(300.dp)
            ) {
                items(seasons){ season ->
                    ItemSeason(
                        season = season
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
private fun OnLifecycle(
    detailShow: MutableState<TvShowEntity>,
    seasons: SnapshotStateList<SeasonEntity>,
    lifecycleOwner: LifecycleOwner,
    isLoading: MutableState<Boolean>,
    detailShowAvailability: MutableState<Boolean>,
    tvShowId: Long?
) {
    Utils.OnLifecycleEvent { _, event ->
        // do stuff on event
        when (event) {
            Lifecycle.Event.ON_RESUME -> {
                isLoading.value = true

                //Clear all list first
                detailShow.value = TvShowEntity()
                seasons.clear()

                detailTvShowViewModel.getDetailTvShow(tvShowId.toString()).observe(lifecycleOwner) { show ->
                    if (show != null) {
                        when (show.status) {
                            Status.LOADING -> {
                                detailShowAvailability.value = true
                                isLoading.value = true
                            }
                            Status.SUCCESS -> {
                                seasons.clear()

                                //Get Season Details from Room
                                detailTvShowViewModel.getDetailTvShowWithSeason(tvShowId.toString())
                                    .observe(lifecycleOwner) { detail ->
                                        if (detail != null) {
                                            runBlocking {
                                                launch {
                                                    detailShow.value = detail.mTvShow
                                                    val listOfSeasons = detail.mSeason
                                                    listOfSeasons.forEach {
                                                        seasons.add(it)
                                                    }
                                                    detailShowAvailability.value = true

                                                    delay(1000)

                                                    isLoading.value = false
                                                }
                                            }
                                        }
                                    }
                            }
                            Status.ERROR -> {
                                runBlocking {
                                    launch {
                                        delay(1000)

                                        detailShowAvailability.value = false
                                        isLoading.value = false
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else -> { /* other stuff */ }
        }
    }
}

private fun setFavStatusToast(
    state: Boolean,
    context: Context
){
    if (state) {
        Toast.makeText(context, R.string.successAddedToDatabase, Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(context, R.string.successRemovedToDatabase, Toast.LENGTH_SHORT).show()
    }
}