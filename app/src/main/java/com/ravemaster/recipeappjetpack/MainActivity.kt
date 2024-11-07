package com.ravemaster.recipeappjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ravemaster.recipeappjetpack.presentation.GetRecipesViewModel
import com.ravemaster.recipeappjetpack.ui.theme.PropoertiesAppJetpackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: GetRecipesViewModel by viewModels()


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

