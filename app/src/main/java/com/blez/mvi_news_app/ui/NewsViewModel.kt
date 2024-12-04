package com.blez.mvi_news_app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blez.mvi_news_app.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository,
) : ViewModel() {
    private val _state = MutableStateFlow(NewsViewState())
    val state: StateFlow<NewsViewState> = _state

    fun handleIntent(intent: NewsIntent) {
        viewModelScope.launch {
            when (intent) {
                NewsIntent.FetchNews -> fetchNews()
            }
        }
    }

    private suspend fun fetchNews() {
        _state.value = _state.value.copy(loading = true, error = null)
        try {
            val news = newsRepository.getNews()
            _state.value = NewsViewState(loading = false, news = news.articles)
        } catch (e: Exception) {
            _state.value =
                NewsViewState(loading = false, error = e.message ?: "Error fetching news")
        }

    }
}