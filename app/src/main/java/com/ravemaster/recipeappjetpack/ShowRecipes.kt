package com.ravemaster.recipeappjetpack

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ravemaster.recipeappjetpack.data.remote.models.RecipesListResponse
import com.ravemaster.recipeappjetpack.data.remote.models.Result

@Composable
fun ShowRecipes(modifier: Modifier = Modifier, recipes: RecipesListResponse) {
    LazyRow (
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp),
        contentPadding = PaddingValues(10.dp),
    ) {
        items(recipes.results.size){ item ->
            ShowRecipeItem(recipes.results[item])
        }
    }
}

@Composable
fun ShowRecipeItem(result: Result) {
    Column(
        modifier = Modifier
            .width(400.dp)
            .height(400.dp)
            .padding(10.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center,
        ){
            LoadImageFromUrl(url = result.thumbnail_url)
        }
        ShowDetails(result)
    }
}

@Composable
fun ShowDetails(result: Result) {
    Text(
        text = result.name,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = Color.Black,
        modifier = Modifier.padding(3.dp)
    )
    Text(
        text = "Servings for ${result.num_servings} people",
        color = Color.Black,
        modifier = Modifier.padding(3.dp)
    )
}

@Composable
fun LoadImageFromUrl(url: String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.placeholder),
        contentDescription = "Image of recipe",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}