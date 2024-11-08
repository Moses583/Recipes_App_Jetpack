package com.ravemaster.recipeappjetpack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ravemaster.recipeappjetpack.data.remote.getfeed.models.FeedsApiResponse
import com.ravemaster.recipeappjetpack.data.remote.getfeed.models.Result

@Composable
fun ShowFeaturedItem(feed: FeedsApiResponse) {
    val result = feed.results[0]
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(8.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Featured recipe",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            ShowFeatureImage(url = result.item.thumbnail_url )
        }
        Text(
            text = result.item.name,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
        ShowServingsRow(result)
    }
}

@Composable
fun ShowRating(result: Result) {
    Column (
        modifier = Modifier
            .width(100.dp)
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = null,
            tint = Color.Green
        )
        Text(
            text = result.item.user_ratings.score.toString(),
            color = Color.Black,
            fontSize = 15.sp
        )
    }

}

@Composable
fun ShowTime(result: Result) {
    val time: String = result.item.cook_time_minutes.toString() + " minutes"
    Column (
        modifier = Modifier
            .width(100.dp)
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(
            imageVector = Icons.Filled.Timer,
            contentDescription = null,
            tint = Color.Blue
        )
        Text(
            text = time,
            color = Color.Black,
            fontSize = 15.sp
        )
    }

}

@Composable
fun ShowServings(result: Result) {
    val servings : String = result.item.num_servings.toString()
    Column(
        modifier = Modifier
            .width(100.dp)
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(
            imageVector = Icons.Filled.People,
            contentDescription = null,
            tint = Color.Black
        )
        Text(
            text = servings,
            color = Color.Black,
            fontSize = 15.sp
        )
    }

}

@Composable
fun ShowServingsRow(result: Result) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ShowRating(result)
        ShowTime(result)
        ShowServings(result)
    }
}


@Composable
fun ShowFeatureImage(url: String) {
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

@Preview(showSystemUi = true)
@Composable
 fun Show() {

}
