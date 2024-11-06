package com.ravemaster.recipeappjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ravemaster.recipeappjetpack.data.remote.models.RecipesListResponse
import com.ravemaster.recipeappjetpack.data.remote.models.Result
import com.ravemaster.recipeappjetpack.presentation.MyViewModel
import com.ravemaster.recipeappjetpack.ui.theme.PropoertiesAppJetpackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: MyViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PropoertiesAppJetpackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val error = viewModel.errors.collectAsState().value
                    val isLoading = viewModel.loading.collectAsState().value
                    val recipes = viewModel.recipes.collectAsState().value

                    LaunchedEffect(Unit) {
                        viewModel.getRecipes(0,20)
                    }

                    if (isLoading) {
                        ShowProgressIndicator()
                    } else {
                        if (error.isNotEmpty()){
                            ShowErrorMessage(error = error)
                        }else{
                            if (recipes.results.isEmpty()) {
                                ShowErrorMessage(error = "No recipes available")
                            } else {
                                ShowRecipes(modifier = Modifier.padding(innerPadding), recipes)
                            }
                        }
                    }

                }
            }
        }
    }



    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        PropoertiesAppJetpackTheme {

        }
    }
}

