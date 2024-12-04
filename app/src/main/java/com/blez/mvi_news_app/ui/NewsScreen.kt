package com.blez.mvi_news_app.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.blez.mvi_news_app.data.domain.news_response.Article

@Composable
fun NewsScreen(newsViewModel: NewsViewModel) {
    val state by newsViewModel.state.collectAsState()
    LaunchedEffect(newsViewModel) {
        newsViewModel.handleIntent(NewsIntent.FetchNews)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        when {
            state.loading -> {

                CircularProgressIndicator(modifier = Modifier.align(CenterHorizontally))
            }

            state.error != null -> {

                Text(text = "Error: ${state.error}", color = Color.Red)
            }

            else -> {

                NewsList(news = state.news)
            }
        }

    }
}

@Composable
fun NewsList(news: List<Article>) {
    LazyColumn {
        items(news) { article ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 1.dp, shape = RectangleShape, color = Color.Black)
                    .padding(
                        all = 8.dp
                    )

            ) {
                Text(text = article.title)
                Text(text = "From \"${article.source.name}\"")
                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
    }

}