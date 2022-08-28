package com.path_studio.moviecatalogue.ui.mainPage.favorite.favoriteMovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.path_studio.moviecatalogue.databinding.FragmentFavoriteMovieBinding
import com.path_studio.moviecatalogue.ui.mainPage.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteMovieFragment : Fragment() {

    private var _binding: FragmentFavoriteMovieBinding? = null
    private val binding get() = _binding

    private val favoriteMovieViewModel:FavoriteMovieViewModel by viewModel()

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
            val adapter = FavoriteMovieAdapter()
            binding?.progressBar?.visibility = View.VISIBLE
            favoriteMovieViewModel.getMovieFav().observe(activity as MainActivity) { movies ->
                binding?.progressBar?.visibility = View.GONE
                if (movies.isEmpty()) binding?.noDataImg?.visibility =
                    View.VISIBLE else binding?.noDataImg?.visibility = View.GONE
                adapter.setFavMovies(movies)
                adapter.notifyDataSetChanged()
            }

            binding?.rvMovieFavorites?.layoutManager = LinearLayoutManager(context)
            binding?.rvMovieFavorites?.setHasFixedSize(true)
            binding?.rvMovieFavorites?.adapter = adapter
        }
    }

}