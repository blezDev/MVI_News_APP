package com.blez.mvi_news_app.ui

import com.blez.mvi_news_app.data.domain.news_response.Article
import com.blez.mvi_news_app.data.domain.news_response.NewsResponse

data class NewsViewState(
    val loading: Boolean = false,
    val news: List<Article> = emptyList(),
    val error: String? = null,
)