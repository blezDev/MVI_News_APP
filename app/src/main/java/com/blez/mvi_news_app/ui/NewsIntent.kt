package com.blez.mvi_news_app.ui

sealed class NewsIntent {
    data object FetchNews : NewsIntent()
}