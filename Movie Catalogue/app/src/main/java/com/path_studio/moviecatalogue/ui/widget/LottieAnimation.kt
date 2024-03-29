package com.path_studio.moviecatalogue.ui.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.path_studio.moviecatalogue.R

@Composable
fun Loader(modifier: Modifier = Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
    Box(modifier = Modifier.fillMaxWidth()){
        LottieAnimation(
            composition = composition,
            modifier = modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            iterations = LottieConstants.IterateForever,
        )
    }
}

@Composable
fun NotFoundAnimation(modifier: Modifier = Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.not_found))
    Box(modifier = Modifier.fillMaxWidth()){
        LottieAnimation(
            composition = composition,
            modifier = modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            iterations = LottieConstants.IterateForever,
        )
    }
}

@Composable
fun NoConnectionAnimation(modifier: Modifier = Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.connection_lost))
    Box(modifier = Modifier.fillMaxWidth()){
        LottieAnimation(
            composition = composition,
            modifier = modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            iterations = LottieConstants.IterateForever,
        )
    }
}