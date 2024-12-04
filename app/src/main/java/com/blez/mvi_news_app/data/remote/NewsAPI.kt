package com.blez.mvi_news_app.data.remote

import com.blez.mvi_news_app.BuildConfig
import com.blez.mvi_news_app.data.domain.news_response.NewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface NewsAPI {
    @GET("everything?q=android&apiKey=${BuildConfig.apiKey}")
    suspend fun getNews() : Response<NewsResponse>
}