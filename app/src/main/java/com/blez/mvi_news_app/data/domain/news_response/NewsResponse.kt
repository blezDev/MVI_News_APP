package com.blez.mvi_news_app.data.domain.news_response

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)