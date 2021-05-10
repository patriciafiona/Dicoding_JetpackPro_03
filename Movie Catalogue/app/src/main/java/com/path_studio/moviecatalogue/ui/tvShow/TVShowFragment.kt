package com.path_studio.moviecatalogue.ui.tvShow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.databinding.FragmentTvShowBinding
import com.path_studio.moviecatalogue.ui.bottomSheet.OnBottomSheetCallbacks
import com.path_studio.moviecatalogue.ui.mainPage.MainActivity
import com.path_studio.moviecatalogue.viewmodel.ViewModelFactory
import com.path_studio.moviecatalogue.vo.Status

class TVShowFragment : BottomSheetDialogFragment(), OnBottomSheetCallbacks {

    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding as FragmentTvShowBinding

    private var currentState: Int = BottomSheetBehavior.STATE_HALF_EXPANDED
    private lateinit var textResult: AppCompatTextView
    private lateinit var filterImage: ImageView

    private lateinit var tvShowViewModel: TvShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //set binding
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)
        val view = binding.root

        //init
        textResult = view.findViewById(R.id.textResult2)
        filterImage = view.findViewById(R.id.indicatorImage2)

        //set bottomSheet Callbacks
        (activity as MainActivity).setOnBottomSheetCallbacks(this)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //default, show half layout
        (activity as MainActivity).closeBottomSheet()

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

            val tvShowAdapter = TvShowAdapter()
            viewModel.getDiscoverTvShow().observe(this, { shows ->
                if (shows != null) {
                    when (shows.status) {
                        Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding?.progressBar?.visibility = View.GONE
                            tvShowAdapter.submitList(shows.data)
                        }
                        Status.ERROR -> {
                            binding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(binding.rvTvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }

        textResult.setOnClickListener {
            (activity as MainActivity).openBottomSheet()
        }

        filterImage.setOnClickListener {
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
                textResult.text = this.getString(R.string.results)
                filterImage.setImageResource(R.drawable.ic_baseline_expand_more_purple)
            }
            BottomSheetBehavior.STATE_HALF_EXPANDED -> {
                textResult.text = this.getString(R.string.list_of_tv_shows)
                filterImage.setImageResource(R.drawable.ic_baseline_expand_less_purple)
            }
        }
    }

}