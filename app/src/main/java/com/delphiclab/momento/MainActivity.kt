package com.delphiclab.momento

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.delphiclab.momento.ui.theme.MomentoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MomentoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->

                    MainContent("Please go to widgets section to add widget to home screen")

                }
            }
        }
    }


}

@Composable
fun MainContent(title: String) {
    Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {
        Text(
            text = "Hello $title!",
        )
    }

}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    MomentoTheme {
        MainContent("Android")
    }
}