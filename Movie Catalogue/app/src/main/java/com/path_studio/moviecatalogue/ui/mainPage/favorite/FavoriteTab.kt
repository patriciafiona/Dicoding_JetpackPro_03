package com.path_studio.moviecatalogue.ui.mainPage.favorite

import androidx.compose.foundation.layout.*
import androidx.compose.material.BackdropScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.ui.ui.theme.Purple700

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavoriteTab(
    navController: NavController,
    backdropScaffoldState: BackdropScaffoldState
) {
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
    }
}