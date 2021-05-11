package com.path_studio.moviecatalogue.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.databinding.FragmentFavoriteBinding
import com.path_studio.moviecatalogue.ui.bottomSheet.OnBottomSheetCallbacks
import com.path_studio.moviecatalogue.ui.mainPage.MainActivity

class FavoriteFragment : BottomSheetDialogFragment(), OnBottomSheetCallbacks {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding as FragmentFavoriteBinding
    private var currentState: Int = BottomSheetBehavior.STATE_HALF_EXPANDED

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.movie,
            R.string.tv_show
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //set binding
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val view = binding.root

        //set bottomSheet Callbacks
        (activity as MainActivity).setOnBottomSheetCallbacks(this)

        //set Tab
        setTab()

        return view
    }

    private fun setTab(){
        val sectionsPagerAdapter = FavoriteTabsAdapter(activity as MainActivity)
        val viewPager: ViewPager2 = binding.followViewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.followTabs
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
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