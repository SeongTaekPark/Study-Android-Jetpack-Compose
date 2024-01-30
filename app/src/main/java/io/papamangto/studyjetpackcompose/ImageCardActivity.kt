package io.papamangto.studyjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.papamangto.studyjetpackcompose.ui.theme.StudyJetpackComposeTheme

class ImageCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isFavorite by rememberSaveable {            // isFavorite.value 를 사용하지 않고 isFavorite 를 사용하기 위해 by 를 사용.
                mutableStateOf(false)
            }

            ImageCard(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(16.dp),
                isFavorite = isFavorite,
            ) { favorite ->
                isFavorite = favorite
            }
        }
    }
}

@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    isFavorite: Boolean,     // isFavorite 로 들어오는 값은 변수가 아니라 상수다.
    onTabFavorite: (Boolean) -> Unit,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        elevation = 5.dp,
    ) {
        Box(
            modifier = Modifier.height(200.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.sample_image_rabbit),
                contentDescription = "poster",
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopEnd,
            ) {
                IconButton(onClick = {
                    onTabFavorite(!isFavorite)
                }) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "favorite",
                        tint = Color.Red,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    StudyJetpackComposeTheme {
        var isFavorite by rememberSaveable {            // isFavorite.value 를 사용하지 않고 isFavorite 를 사용하기 위해 by 를 사용.
            mutableStateOf(false)
        }

        ImageCard(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(16.dp),
            isFavorite = isFavorite,
        ) { favorite ->
            isFavorite = favorite
        }
    }
}