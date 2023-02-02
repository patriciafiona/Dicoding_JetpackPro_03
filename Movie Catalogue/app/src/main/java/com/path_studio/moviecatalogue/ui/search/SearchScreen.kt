package com.path_studio.moviecatalogue.ui.search

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.data.entities.SearchEntity
import com.path_studio.moviecatalogue.helper.SearchDisplay
import com.path_studio.moviecatalogue.ui.ui.theme.Purple500
import com.path_studio.moviecatalogue.ui.widget.ItemSearch
import com.path_studio.moviecatalogue.ui.widget.Loader
import com.path_studio.moviecatalogue.ui.widget.NoConnectionAnimation
import com.path_studio.moviecatalogue.ui.widget.NotFoundAnimation
import com.path_studio.moviecatalogue.util.Utils
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel


private lateinit var viewModel: SearchViewModel
private val suggestionsList = arrayListOf(
    "Wednesday", "Last of us", "Minions",
    "Everything Everywhere All at Once", "The Simpsons",
    "Spiderman"
)

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SearchScreen(
    navController: NavController,
    state: SearchState = rememberSearchState(),
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    viewModel = koinViewModel()

    if(Utils.isInternetAvailable(context)) {
        Column(
            modifier = modifier
                .fillMaxSize()
        ) {

            SearchBar(
                query = state.query,
                onQueryChange = { state.query = it },
                onSearchFocusChange = { state.focused = it },
                onClearQuery = { state.query = TextFieldValue("") },
                onBack = { state.query = TextFieldValue("") },
                searching = state.searching,
                focused = state.focused,
                modifier = modifier
            )

            LaunchedEffect(state.query.text) {
                state.searching = true
                delay(100)

                if (state.query.text.isNotEmpty()) {
                    val results = viewModel.getSearchResult(state.query.text)
                    results.observe(lifecycleOwner) { detail ->
                        state.searchResults = detail
                        state.searching = false
                    }
                }
            }

            when (state.searchDisplay) {
                SearchDisplay.InitialResults -> {

                }
                SearchDisplay.NoResults -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    ) {
                        Loader(
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }

                SearchDisplay.Suggestions -> {
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(minSize = 150.dp),
                        contentPadding = PaddingValues(
                            start = 12.dp,
                            top = 16.dp,
                            end = 12.dp,
                            bottom = 16.dp
                        ),
                    ) {
                        items(suggestionsList) { suggestion ->
                            Box(
                                modifier = Modifier
                                    .padding(vertical = 10.dp, horizontal = 5.dp)
                                    .height(50.dp)
                                    .clip(RoundedCornerShape(50))
                                    .clickable {
                                        state.query = TextFieldValue(suggestion)
                                    }
                            ) {
                                Image(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .drawWithCache {
                                            val gradient = Brush.horizontalGradient(
                                                colors = listOf(Purple500, Color.Transparent),
                                                startX = size.width / 3,
                                                endX = size.width
                                            )
                                            onDrawWithContent {
                                                drawContent()
                                                drawRect(gradient, blendMode = BlendMode.Multiply)
                                            }
                                        },
                                    painter = painterResource(id = R.drawable.cloud_bg),
                                    contentDescription = stringResource(id = R.string.description),
                                    contentScale = ContentScale.Crop
                                )

                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.Start
                                ) {
                                    Text(
                                        modifier = Modifier
                                            .padding(vertical = 10.dp, horizontal = 15.dp),
                                        text = suggestion,
                                        style = TextStyle(
                                            color = Color.White,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold
                                        ),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }
                }

                SearchDisplay.Results -> {
                    if (state.searchResults.isNotEmpty()) {
                        LazyColumn(
                            modifier = Modifier.weight(1f)
                        ) {
                            items(state.searchResults) { searchResult ->
                                ItemSearch(
                                    navController = navController,
                                    searchResult
                                )
                            }
                        }
                    } else {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            NotFoundAnimation(
                                modifier = Modifier
                                    .fillMaxWidth(.7f)
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            androidx.compose.material.Text(
                                text = "Results Not Found",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 24.sp,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }
                }
            }
        }
    }else{
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoConnectionAnimation(
                modifier = Modifier
                    .fillMaxSize(.7f)
            )

            Spacer(modifier = Modifier.height(20.dp))

            androidx.compose.material.Text(
                text = "Connection Lost",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Stable
class SearchState(
    query: TextFieldValue,
    focused: Boolean,
    searching: Boolean,
    suggestions: List<String> = suggestionsList,
    searchResults: List<SearchEntity> = emptyList()
) {
    var query by mutableStateOf(query)
    var focused by mutableStateOf(focused)
    var searching by mutableStateOf(searching)
    var suggestions by mutableStateOf(suggestions)
    var searchResults by mutableStateOf(searchResults)

    val searchDisplay: SearchDisplay
        get() = when {
            !focused && query.text.isEmpty() -> SearchDisplay.InitialResults
            focused && query.text.isEmpty() -> SearchDisplay.Suggestions

            searchResults.isEmpty() -> SearchDisplay.NoResults

            else -> SearchDisplay.Results
        }

    override fun toString(): String {
        return "🚀 State query: $query, focused: $focused, searching: $searching " +
                "suggestions: ${suggestions.size}, " +
                "searchResults: ${searchResults.size}, " +
                "searchDisplay: $searchDisplay"

    }
}

@Composable
fun rememberSearchState(
    query: TextFieldValue = TextFieldValue(""),
    focused: Boolean = false,
    searching: Boolean = false,
    suggestions: List<String> = emptyList(),
    searchResults: List<SearchEntity> = emptyList()
): SearchState {
    return remember {
        SearchState(
            query = query,
            focused = focused,
            searching = searching,
            suggestions = suggestions,
            searchResults = searchResults
        )
    }
}

@ExperimentalAnimationApi
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(
    query: TextFieldValue,
    onQueryChange: (TextFieldValue) -> Unit,
    onSearchFocusChange: (Boolean) -> Unit,
    onClearQuery: () -> Unit,
    onBack: ()-> Unit,
    searching: Boolean,
    focused: Boolean,
    modifier: Modifier = Modifier
) {

    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        AnimatedVisibility(visible = focused) {
            // Back button
            IconButton(
                modifier = Modifier.padding(start =2.dp),
                onClick = {
                    focusManager.clearFocus()
                    keyboardController?.hide()
                    onBack()
                }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        }

        SearchTextField(
            query,
            onQueryChange,
            onSearchFocusChange,
            onClearQuery,
            searching,
            focused,
            modifier.weight(1f)
        )
    }
}

@Composable
fun SearchTextField(
    query: TextFieldValue,
    onQueryChange: (TextFieldValue) -> Unit,
    onSearchFocusChange: (Boolean) -> Unit,
    onClearQuery: () -> Unit,
    searching: Boolean,
    focused: Boolean,
    modifier: Modifier = Modifier
) {

    val focusRequester = remember { FocusRequester() }

    Surface(
        modifier = modifier
            .then(
                Modifier
                    .height(56.dp)
                    .padding(
                        top = 8.dp,
                        bottom = 8.dp,
                        start = if (!focused) 16.dp else 0.dp,
                        end = 16.dp
                    )
            ),
        color = Color(0xffF5F5F5),
        shape = RoundedCornerShape(percent = 50),
    ) {

        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = modifier
            ) {

                if (query.text.isEmpty()) {
                    SearchHint(modifier.padding(start = 24.dp, end = 8.dp))
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    BasicTextField(
                        value = query,
                        onValueChange = onQueryChange,
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .onFocusChanged {
                                onSearchFocusChange(it.isFocused)
                            }
                            .focusRequester(focusRequester)
                            .padding(top = 9.dp, bottom = 8.dp, start = 24.dp, end = 8.dp),
                        singleLine = true
                    )

                    when {
                        searching -> {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .padding(horizontal = 6.dp)
                                    .size(36.dp)
                            )
                        }
                        query.text.isNotEmpty() -> {
                            IconButton(onClick = onClearQuery) {
                                Icon(imageVector = Icons.Filled.Cancel, contentDescription = null)
                            }
                        }
                    }
                }
            }
        }

    }
}

@Composable
private fun SearchHint(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)

    ) {
        Text(
            color = Color(0xff757575),
            text = "Search a Tag or Description",
        )
    }
}