package com.metinozcura.jetpackcomposeplayground

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.metinozcura.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
        }
    }
}

@Composable
fun DefaultPreview() {
    JetpackComposePlaygroundTheme {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Spacer(modifier = Modifier
                    .height(16.dp)
                    .fillMaxWidth())
                CreatePager()
            }
            items(20) {
                CreateListItem(item = DogeItem())
            }
        }
    }
}

@Composable
fun CreateListItem(item: DogeItem) {
    Row(
        modifier = Modifier
            .height(72.dp)
            .padding(horizontal = 16.dp, vertical = 0.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_doge),
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .clip(shape = RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = item.quote, color = Color.DarkGray)
            Text(text = item.author, color = Color.LightGray)
        }
    }
    /* GlideImage(
         data = item.imageUrl,
         modifier = Modifier
             .aspectRatio(1.0f)
             .fillMaxHeight(),
         contentDescription = null
     ) */
}

@Composable
fun CreatePager() {
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.width(0.dp))
        for (i in 0 until 10) {
            CreatePagerItem()
        }
    }
}

@Composable
fun CreatePagerItem() {
    Image(
        painter = painterResource(id = R.drawable.img_doge),
        contentDescription = null,
        modifier = Modifier
            .width(200.dp)
            .aspectRatio(1.0f)
            .clip(shape = RoundedCornerShape(8.dp)),
        contentScale = ContentScale.Fit
    )
}