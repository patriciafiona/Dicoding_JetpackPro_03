package com.path_studio.moviecatalogue.navigations.bottomNav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Tv
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var index: Int, var title: String, var icon: ImageVector, var screen_route: String){
    object ListMovie : BottomNavItem(0, "List Movie", Icons.Default.Movie,"list_movie_tab")
    object Favorites: BottomNavItem(1, "Favorites", Icons.Default.Favorite,"favorites_tab")
    object ListTvShow: BottomNavItem(2, "List TV Show", Icons.Default.Tv,"list_tv_show_tab")
}