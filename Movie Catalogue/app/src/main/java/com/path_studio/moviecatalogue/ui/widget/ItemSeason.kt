package com.path_studio.moviecatalogue.ui.widget

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.data.source.local.enitity.SeasonEntity
import com.path_studio.moviecatalogue.util.Utils

@Composable
fun ItemSeason(
    season: SeasonEntity
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor =  Color.White,
        ),
    ) {
        Row {
            if(season.posterPath != null && season.posterPath != "null") {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://image.tmdb.org/t/p/w500/${season.posterPath}")
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
                    .padding(10.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                   Text(
                       text = "Season ${season.seasonNumber}",
                       style = TextStyle(
                           color = Color.Black,
                           fontSize = 16.sp,
                           fontWeight = FontWeight.Bold
                       ),
                       modifier = Modifier.weight(.7f)
                   )

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = "${season.airDate?.let { Utils.changeStringToDateFormat(it) }} | ${season.episodeCount}",
                        style = TextStyle(
                            color = Color.Gray,
                            fontSize = 12.sp,
                            textAlign = TextAlign.End
                        ),
                        modifier = Modifier.weight(1f)
                    )
                }

                Text(
                    text = "Season ${season.seasonNumber} premiered on ${season.airDate?.let {
                        Utils.changeStringToDateFormat(
                            it
                        )
                    }}.",
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 12.sp,
                    )
                )

                Spacer(modifier = Modifier.width(10.dp))

                if(season.overview != null) {
                    season.overview?.let {
                        Text(
                            text = it,
                            style = TextStyle(
                                color = Color.Gray,
                                fontSize = 12.sp,
                            ),
                             maxLines = 3,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }else{
                    Text(
                        text = "No description",
                        style = TextStyle(
                            color = Color.Gray,
                            fontSize = 12.sp,
                        )
                    )
                }
            }
        }
    }
}