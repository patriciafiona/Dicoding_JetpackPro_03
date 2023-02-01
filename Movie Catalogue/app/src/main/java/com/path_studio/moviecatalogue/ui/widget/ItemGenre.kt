package com.path_studio.moviecatalogue.ui.widget

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.path_studio.moviecatalogue.ui.ui.theme.Purple700

@Composable
fun ItemGenre(genre: String) {
    Card(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 5.dp),
    ) {
        Text(
            modifier = Modifier
                .padding(10.dp),
            text = genre,
            style = TextStyle(
                color = Purple700,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}