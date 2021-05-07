package com.path_studio.moviecatalogue.ui.tvShow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.databinding.FragmentTvShowBinding
import com.path_studio.moviecatalogue.di.Injection.provideImdbRepository
import com.path_studio.moviecatalogue.ui.bottomSheet.OnBottomSheetCallbacks
import com.path_studio.moviecatalogue.ui.mainPage.MainActivity

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
            tvShowViewModel = TvShowViewModel(provideImdbRepository(activity as MainActivity))
            val shows = tvShowViewModel.getDiscoverTvShow()

            val tvShowAdapter = TvShowAdapter()

            shows.observe(this, { show ->
                tvShowAdapter.setTvShow(show)
                tvShowAdapter.notifyDataSetChanged()
            })

            tvShowViewModel.getLoading().observe(this, {
                binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
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