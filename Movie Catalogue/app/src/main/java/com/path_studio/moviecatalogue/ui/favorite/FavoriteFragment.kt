package com.path_studio.moviecatalogue.ui.favorite

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.databinding.FragmentFavoriteBinding
import com.path_studio.moviecatalogue.databinding.FragmentMovieBinding
import com.path_studio.moviecatalogue.di.Injection
import com.path_studio.moviecatalogue.ui.bottomSheet.OnBottomSheetCallbacks
import com.path_studio.moviecatalogue.ui.mainPage.MainActivity
import com.path_studio.moviecatalogue.ui.movie.MovieAdapter
import com.path_studio.moviecatalogue.ui.movie.MovieViewModel

class FavoriteFragment : BottomSheetDialogFragment(), OnBottomSheetCallbacks {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding as FragmentFavoriteBinding
    private var currentState: Int = BottomSheetBehavior.STATE_HALF_EXPANDED

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //set binding
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val view = binding.root

        //set bottomSheet Callbacks
        (activity as MainActivity).setOnBottomSheetCallbacks(this)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //default, show half layout
        (activity as MainActivity).closeBottomSheet()

        binding.textResult3.setOnClickListener {
            (activity as MainActivity).openBottomSheet()
        }

        binding.indicatorImage3.setOnClickListener {
            if (currentState == BottomSheetBehavior.STATE_EXPANDED) {
                (activity as MainActivity).closeBottomSheet()
            } else if (currentState == BottomSheetBehavior.STATE_HALF_EXPANDED){
                (activity as MainActivity).openBottomSheet()
            }
        }
    }

    override fun onStateChanged(bottomSheet: View, newState: Int) {
        currentState = newState
        when (newState) {
            BottomSheetBehavior.STATE_EXPANDED -> {
                binding.textResult3.text = this.getString(R.string.results)
                binding.indicatorImage3.setImageResource(R.drawable.ic_baseline_expand_more_purple)
            }
            BottomSheetBehavior.STATE_HALF_EXPANDED -> {
                binding.textResult3.text = this.getString(R.string.my_favorites)
                binding.indicatorImage3.setImageResource(R.drawable.ic_baseline_expand_less_purple)
            }
        }
    }

}