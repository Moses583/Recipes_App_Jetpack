package com.ravemaster.recipeappjetpack

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ravemaster.recipeappjetpack.data.remote.gettags.models.Result
import com.ravemaster.recipeappjetpack.data.remote.gettags.models.TagsApiResponse
import com.ravemaster.recipeappjetpack.presentation.GetRecipesViewModel

@Composable
fun ShowTags(tags: TagsApiResponse, recipesViewModel: GetRecipesViewModel) {
    LazyRow (
        contentPadding = PaddingValues(10.dp),
    ) {
        items(tags.results.size){ item ->
            ShowTagsItem(tags.results[item],recipesViewModel)
        }
    }
}

@Composable
fun ShowTagsItem(result: Result, recipesViewModel: GetRecipesViewModel) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(8.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(16.dp),
        onClick = {
            recipesViewModel.getRecipes(0,20,result.name)
        }
    ){
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(50.dp),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = result.display_name,
                color = Color.Black,
                modifier = Modifier.padding(3.dp)
            )
        }

    }
}
