package com.ravemaster.recipeappjetpack

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ravemaster.recipeappjetpack.data.remote.gettags.models.Result
import com.ravemaster.recipeappjetpack.data.remote.gettags.models.TagsApiResponse

@Composable
fun ShowTags(tags: TagsApiResponse) {
    LazyRow (
        modifier = Modifier
            .height(20.dp)
            .padding(10.dp),
        contentPadding = PaddingValues(10.dp),
    ) {
        items(tags.results.size){ item ->
            ShowTagsItem(tags.results[item])
        }
    }
}

@Composable
fun ShowTagsItem(result: Result) {
    Card(
        modifier = Modifier
            .height(20.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp)
    ){
        Box(

        ){
            Text(
                text = result.display_name,
                color = Color.Black,
                modifier = Modifier.padding(3.dp)
            )
        }

    }
}
