package com.blez.mvi_news_app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.blez.mvi_news_app.ui.theme.MVI_News_APPTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel:NewsViewModel by viewModels<NewsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVI_News_APPTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                 Surface(
                        modifier = Modifier.padding(innerPadding),
                     color = MaterialTheme.colorScheme.background
                 ) {
                     NewsScreen(newsViewModel = viewModel)

                 }
                }
            }
        }
    }
}

