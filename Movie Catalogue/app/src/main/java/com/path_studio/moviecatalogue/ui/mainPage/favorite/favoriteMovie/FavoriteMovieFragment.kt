package com.path_studio.moviecatalogue.ui.mainPage.favorite.favoriteMovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.databinding.FragmentFavoriteMovieBinding
import com.path_studio.moviecatalogue.ui.mainPage.MainActivity
import com.path_studio.moviecatalogue.ui.mainPage.favorite.FavoriteFragment
import com.path_studio.moviecatalogue.viewmodel.ViewModelFactory

class FavoriteMovieFragment : Fragment() {

    private var _binding: FragmentFavoriteMovieBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteMovieBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavoriteMovieViewModel::class.java]

            val adapter = FavoriteMovieAdapter()
            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.getMovieFav().observe(activity as MainActivity, { movies ->
                binding?.progressBar?.visibility = View.GONE
                if (movies.isEmpty()) binding?.noDataImg?.visibility = View.VISIBLE else binding?.noDataImg?.visibility = View.GONE
                adapter.setFavMovies(movies)
                adapter.notifyDataSetChanged()
            })

            binding?.rvMovieFavorites?.layoutManager = LinearLayoutManager(context)
            binding?.rvMovieFavorites?.setHasFixedSize(true)
            binding?.rvMovieFavorites?.adapter = adapter
        }
    }

}