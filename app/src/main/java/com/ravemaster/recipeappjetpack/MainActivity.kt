package com.ravemaster.recipeappjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ravemaster.recipeappjetpack.presentation.GetRecipesViewModel
import com.ravemaster.recipeappjetpack.presentation.TagsViewModel
import com.ravemaster.recipeappjetpack.ui.theme.PropoertiesAppJetpackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val recipesViewModel: GetRecipesViewModel by viewModels()
    val tagsViewModel: TagsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PropoertiesAppJetpackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    LaunchedEffect(Unit) {
                        tagsViewModel.getTags()
                        recipesViewModel.getRecipes(0,20)
                    }
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    @Composable
    fun MainScreen(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
//            TagsSection()
            RecipesSection()
        }
    }

    @Composable
    fun TagsSection() {
        val error = tagsViewModel.errors.collectAsState().value
        val isLoading = tagsViewModel.loading.collectAsState().value
        val tags = tagsViewModel.tags.collectAsState().value
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            if (isLoading) {
                ShowProgressIndicator()
            } else {
                if (error.isNotEmpty()){
                    ShowErrorMessage(error = error)
                }else{
                    if (tags.results.isEmpty()) {
                        ShowErrorMessage(error = "No recipes available")
                    } else {
                        ShowTags(tags)
                    }
                }
            }
        }
    }

    @Composable
    fun RecipesSection() {
        val error = recipesViewModel.errors.collectAsState().value
        val isLoading = recipesViewModel.loading.collectAsState().value
        val recipes = recipesViewModel.recipes.collectAsState().value
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            if (isLoading) {
                ShowProgressIndicator()
            } else {
                if (error.isNotEmpty()){
                    ShowErrorMessage(error = error)
                }else{
                    if (recipes.results.isEmpty()) {
                        ShowErrorMessage(error = "No recipes available")
                    } else {
                        ShowRecipes(recipes)
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

