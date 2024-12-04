package com.blez.mvi_news_app.data.repository

import com.blez.mvi_news_app.data.domain.news_response.NewsResponse
import com.blez.mvi_news_app.data.remote.NewsAPI
import javax.inject.Inject

class NewsRepository @Inject constructor(val newsAPI: NewsAPI) {
    suspend fun getNews() : NewsResponse {
       try {
           newsAPI.getNews().body()?.let {
               return it
           }
           return throw Exception("Error fetching news")
       }catch (e: Exception) {
           throw Exception("Error fetching news")
       }
    }
}