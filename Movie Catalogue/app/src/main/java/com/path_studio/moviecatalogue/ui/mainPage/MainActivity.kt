package com.path_studio.moviecatalogue.ui.mainPage

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.databinding.ActivityMainBinding
import com.path_studio.moviecatalogue.ui.bottomSheet.OnBottomSheetCallbacks
import com.path_studio.moviecatalogue.ui.search.SearchActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var listener: OnBottomSheetCallbacks? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //removing the shadow from the action bar
        supportActionBar?.elevation = 0f

        //Setting the Bottom Navigator
        setBottomNav()

        //set backdrop
        configureBackdrop()

        binding.searchButton.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setBottomNav(){
        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_movie,
            R.id.navigation_favorite,
            R.id.navigation_tvShow
        )
            .build()
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(navView, navController)
    }

    fun setOnBottomSheetCallbacks(onBottomSheetCallbacks: OnBottomSheetCallbacks) {
        this.listener = onBottomSheetCallbacks
    }

    fun closeBottomSheet() {
        mBottomSheetBehavior?.state = BottomSheetBehavior.STATE_HALF_EXPANDED
    }

    fun openBottomSheet() {
        mBottomSheetBehavior?.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private var mBottomSheetBehavior: BottomSheetBehavior<View?>? = null

    private fun configureBackdrop() {
        val fragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)

        fragment?.view?.let {
            BottomSheetBehavior.from(it).let { bs ->
                bs.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                    override fun onSlide(bottomSheet: View, slideOffset: Float) {}

                    override fun onStateChanged(bottomSheet: View, newState: Int) {
                        listener?.onStateChanged(bottomSheet, newState)
                    }
                })

                bs.isFitToContents = false
                bs.expandedOffset = 200
                bs.state = BottomSheetBehavior.STATE_HALF_EXPANDED

                mBottomSheetBehavior = bs
            }
        }
    }
}