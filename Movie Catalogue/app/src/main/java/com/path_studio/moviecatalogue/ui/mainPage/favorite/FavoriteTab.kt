package com.path_studio.moviecatalogue.ui.mainPage.favorite

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.ui.ui.theme.Purple700
import com.path_studio.moviecatalogue.ui.widget.FavMovieTabContentScreen
import com.path_studio.moviecatalogue.ui.widget.FavTvShowTabContentScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class,
    ExperimentalPagerApi::class
)
@Composable
fun FavoriteTab(
    navController: NavController,
    backdropScaffoldState: BackdropScaffoldState,
    favoriteMovieList: SnapshotStateList<MovieEntity>,
    favoriteTvShowList: SnapshotStateList<TvShowEntity>,
    favoriteMovieAvailability: MutableState<Boolean>,
    favoriteTvShowAvailability: MutableState<Boolean>
) {
    val pagerState = com.google.accompanist.pager.rememberPagerState(pageCount = 2)

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
                text = stringResource(id = R.string.my_favorites),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Icon(
                imageVector =
                if(backdropScaffoldState.isConcealed) {
                    Icons.Default.ArrowDropDown
                } else {
                    Icons.Default.ArrowDropUp
                } ,
                tint = Purple700,
                contentDescription = stringResource(id = R.string.show_indicator)
            )
        }
        Tabs(pagerState = pagerState)

        TabsContent(
            pagerState = pagerState,
            favoriteMovieList = favoriteMovieList,
            favoriteTvShowList = favoriteTvShowList,
            favoriteMovieAvailability = favoriteMovieAvailability,
            favoriteTvShowAvailability = favoriteTvShowAvailability,
            navController = navController
        )
    }
}

@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {
    val list = listOf(
        "Movie",
        "Tv Show",
    )
    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Purple700,
        contentColor = Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = Color.White
            )
        }
    ) {
        list.forEachIndexed { index, _ ->
            Tab(
                text = {
                    Text(
                        list[index],
                        color = if (pagerState.currentPage == index) Color.White else Color.LightGray
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}
@ExperimentalPagerApi
@Composable
fun TabsContent(
    pagerState: PagerState,
    navController: NavController,
    favoriteMovieList: SnapshotStateList<MovieEntity>,
    favoriteTvShowList: SnapshotStateList<TvShowEntity>,
    favoriteMovieAvailability: MutableState<Boolean>,
    favoriteTvShowAvailability: MutableState<Boolean>
) {
    com.google.accompanist.pager.HorizontalPager(state = pagerState) { page ->
        when (page) {
            0 -> FavMovieTabContentScreen(
                favoriteMovieList = favoriteMovieList,
                favoriteMovieAvailability = favoriteMovieAvailability,
                navController = navController
            )
            1 -> FavTvShowTabContentScreen(
                favoriteTvShowList = favoriteTvShowList,
                favoriteTvShowAvailability = favoriteTvShowAvailability,
                navController = navController
            )
        }
    }
}