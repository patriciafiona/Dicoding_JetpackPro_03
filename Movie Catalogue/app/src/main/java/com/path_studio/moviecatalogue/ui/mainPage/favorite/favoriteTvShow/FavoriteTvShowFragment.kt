package com.path_studio.moviecatalogue.ui.mainPage.favorite.favoriteTvShow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.path_studio.moviecatalogue.databinding.FragmentFavoriteTvShowBinding
import com.path_studio.moviecatalogue.ui.mainPage.MainActivity

class FavoriteTvShowFragment : Fragment() {

    private var _binding: FragmentFavoriteTvShowBinding? = null
    private val binding get() = _binding

    private val favoriteTvShowViewModel: FavoriteTvShowViewModel by viewModels()

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
            val adapter = FavoriteTvShowAdapter()
            binding?.progressBar?.visibility = View.VISIBLE
            favoriteTvShowViewModel.getTvShowFav().observe(activity as MainActivity) { shows ->
                binding?.progressBar?.visibility = View.GONE
                if (shows.isEmpty()) binding?.noDataImg?.visibility =
                    View.VISIBLE else binding?.noDataImg?.visibility = View.GONE
                adapter.setFavShows(shows)
                adapter.notifyDataSetChanged()
            }

            binding?.rvTvShowFavorites?.layoutManager = LinearLayoutManager(context)
            binding?.rvTvShowFavorites?.setHasFixedSize(true)
            binding?.rvTvShowFavorites?.adapter = adapter
        }
    }

}