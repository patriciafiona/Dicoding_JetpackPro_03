package com.path_studio.moviecatalogue.ui.mainPage.favorite.favoriteTvShow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.databinding.FragmentFavoriteMovieBinding
import com.path_studio.moviecatalogue.databinding.FragmentFavoriteTvShowBinding
import com.path_studio.moviecatalogue.ui.mainPage.MainActivity
import com.path_studio.moviecatalogue.ui.mainPage.favorite.favoriteMovie.FavoriteMovieAdapter
import com.path_studio.moviecatalogue.ui.mainPage.favorite.favoriteMovie.FavoriteMovieViewModel
import com.path_studio.moviecatalogue.viewmodel.ViewModelFactory

class FavoriteTvShowFragment : Fragment() {

    private var _binding: FragmentFavoriteTvShowBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteTvShowBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavoriteTvShowViewModel::class.java]

            val adapter = FavoriteTvShowAdapter()
            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.getTvShowFav().observe(activity as MainActivity, { shows ->
                binding?.progressBar?.visibility = View.GONE
                adapter.setFavShows(shows)
                adapter.notifyDataSetChanged()
            })

            binding?.rvTvShowFavorites?.layoutManager = LinearLayoutManager(context)
            binding?.rvTvShowFavorites?.setHasFixedSize(true)
            binding?.rvTvShowFavorites?.adapter = adapter
        }
    }

}