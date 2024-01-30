package io.papamangto.studyjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.papamangto.studyjetpackcompose.ui.theme.StudyJetpackComposeTheme

class BoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyJetpackComposeTheme {
                Box(
                    modifier = Modifier
                        .background(color = Color.Green)
                        .fillMaxWidth()
                        .height(200.dp)
                ){
                    Text(text = "Hello")
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                        contentAlignment = Alignment.BottomEnd,
                    ) {
                        Text(text = "1234567~~~!!!")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    StudyJetpackComposeTheme {
        Greeting2("Android")
    }
}