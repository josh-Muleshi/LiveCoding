package com.example.livecode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.livecode.ui.theme.LiveCodeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LiveCodeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val photos = listOf(
                        R.drawable.ic_image1,
                        R.drawable.ic_image2,
                        R.drawable.ic_image3,
                        R.drawable.ic_image4,
                        R.drawable.ic_image5,
                        R.drawable.ic_image6,
                        R.drawable.ic_image8
                    )
                    ListPhoto(photos)
                }
            }
        }
    }
}

@Composable
fun ListPhoto(photos : List<Int>) {
    LazyRow(
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxSize(),
        content = {
            items(photos){ photo ->
                ItemUI(photo = photo)
            }
        }
    )
}

@Composable
fun ItemUI(photo : Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Card(modifier = Modifier
            .padding(top = 24.dp, bottom = 24.dp, end = 7.dp, start = 8.dp)
            .width(300.dp),
            elevation = 2.dp,
            shape = RoundedCornerShape(corner = CornerSize(10.dp))
        ) {
            Image(
                painter = painterResource(id = photo),
                contentDescription = "photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}
