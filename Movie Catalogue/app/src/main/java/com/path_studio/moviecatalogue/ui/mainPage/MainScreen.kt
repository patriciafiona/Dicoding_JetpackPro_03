package com.path_studio.moviecatalogue.ui.mainPage

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.path_studio.moviecatalogue.helper.BackPress
import kotlinx.coroutines.delay
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.navigations.bottomNav.BottomNavItem
import com.path_studio.moviecatalogue.ui.ui.theme.Purple900
import com.path_studio.moviecatalogue.ui.ui.theme.Teal700
import com.path_studio.moviecatalogue.ui.widget.BottomNav

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(
    navController: NavController,
    appCompatActivity: AppCompatActivity
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val backdropScaffoldState = rememberBackdropScaffoldState(
        BackdropValue.Concealed
    )

    //bottomNavigation
    val currentBottomTab = remember { mutableStateOf(0) }
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

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.tmdb),
                        contentDescription = "TMDB logo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth(.4f)
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Icon"
                        )
                    }
                }
            }
        },
        frontLayerContent = {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {

                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    bottomNavItems.forEach { item ->
                        Column (
                            modifier = Modifier
                                .weight(1f)
                                .background(Color.White)
                                .clickable {
                                    currentBottomTab.value = item.index
                                },
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title,
                                modifier = Modifier.size(24.dp),
                                tint = if(currentBottomTab.value == item.index) { Purple900 } else { Color.Gray }
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = item.title,
                                style = TextStyle(
                                    color = if(currentBottomTab.value == item.index) { Purple900 } else { Color.Gray },
                                    fontSize = 11.sp
                                )
                            )
                        }
                    }
                }
            }
        },
    )
}