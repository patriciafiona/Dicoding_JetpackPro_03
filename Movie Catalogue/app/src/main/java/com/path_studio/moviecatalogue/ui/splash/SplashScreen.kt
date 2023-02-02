package com.path_studio.moviecatalogue.ui.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.navigations.TmdbScreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    val scale = remember {
        Animatable(0.0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(800, easing = {
                OvershootInterpolator(4f).getInterpolation(it)
            })
        )
        delay(1000)
        navController.navigate(TmdbScreen.MainScreen.route) {
            popUpTo(TmdbScreen.SplashScreen.route) {
                inclusive = true
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.tmdb),
            contentDescription = "Splash image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth(.6f)
                .scale(scale.value)
        )
    }
}