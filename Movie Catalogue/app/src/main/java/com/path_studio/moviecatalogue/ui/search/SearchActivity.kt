package com.path_studio.moviecatalogue.ui.search

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mancj.materialsearchbar.MaterialSearchBar
import com.mancj.materialsearchbar.adapter.SuggestionsAdapter
import com.path_studio.moviecatalogue.BuildConfig
import com.path_studio.moviecatalogue.data.entities.SearchEntity
import com.path_studio.moviecatalogue.data.source.remote.response.SearchResponse
import com.path_studio.moviecatalogue.databinding.ActivitySearchBinding
import com.path_studio.moviecatalogue.di.Injection
import com.path_studio.moviecatalogue.ui.mainPage.MainActivity

class SearchActivity : AppCompatActivity() {

    private lateinit var searchViewModel: SearchViewModel

    private lateinit var binding: ActivitySearchBinding
    private lateinit var searchResult: SearchResponse

    private var listSearchResult: ArrayList<SearchEntity> = ArrayList()
    private lateinit var searchAdapter: SearchAdapter

    companion object {
        private const val API_KEY = BuildConfig.TMDB_API_KEY
        private const val language = "en-US"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //set Material Search Bar
        settingSearch()

        binding.buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun settingSearch() {
        binding.searchBar.setMaxSuggestionCount(8)

        //enable search bar callbacks
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        searchAdapter = SearchAdapter(inflater)

        binding.searchBar.setOnSearchActionListener(object : MaterialSearchBar.OnSearchActionListener {
            override fun onSearchStateChanged(enabled: Boolean) {}

            override fun onSearchConfirmed(text: CharSequence) {
                //startSearch(text.toString(), true, null, true);
            }

            override fun onButtonClicked(buttonCode: Int) {
                if (buttonCode == MaterialSearchBar.BUTTON_NAVIGATION) {
                    //opening or closing a navigation drawer
                } else if (buttonCode == MaterialSearchBar.BUTTON_BACK) {
                    binding.searchBar.clearSuggestions()
                    binding.searchBar.closeSearch()
                }
            }
        })
        binding.searchBar.addTextChangeListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                binding.searchBar.setCustomSuggestionAdapter(searchAdapter)

                if (binding.searchBar.text.isNotEmpty()) {
                    searchViewModel = SearchViewModel(Injection.provideImdbRepository(this@SearchActivity))
                    val results = searchViewModel.getSearchResult(binding.searchBar.text)

                    results.observe(this@SearchActivity, { detail ->
                        searchAdapter.setResult(detail)
                        searchAdapter.suggestions = detail

                        searchAdapter.notifyDataSetChanged()
                        binding.searchBar.showSuggestionsList()
                    })

                    searchViewModel.getLoading().observe(this@SearchActivity, {
                        if (it) {
                            binding.progressBar.visibility = View.VISIBLE
                        }else{
                            binding.progressBar.visibility = View.GONE
                        }
                    })
                } else {
                    binding.searchBar.clearSuggestions()
                    binding.searchBar.hideSuggestionsList()
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
        binding.searchBar.setSuggestionsClickListener(object :
            SuggestionsAdapter.OnItemViewClickListener {
            override fun OnItemClickListener(position: Int, v: View) {}
            override fun OnItemDeleteListener(position: Int, v: View) {}
        })
    }

}