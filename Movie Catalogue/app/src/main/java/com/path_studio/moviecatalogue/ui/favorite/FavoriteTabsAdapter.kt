package com.path_studio.moviecatalogue.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.path_studio.moviecatalogue.ui.favorite.favoriteMovie.FavoriteMovieFragment
import com.path_studio.moviecatalogue.ui.favorite.favoriteTvShow.FavoriteTvShowFragment

class FavoriteTabsAdapter (activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FavoriteMovieFragment()
            1 -> fragment = FavoriteTvShowFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 2
    }
}