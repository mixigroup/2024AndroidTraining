package jp.co.mixi.androidtraining.sns.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.co.mixi.androidtraining.sns.data.repository.DefaultTimelineRepository
import jp.co.mixi.androidtraining.sns.data.repository.TimelineRepository
import kotlinx.coroutines.launch

class TimelineViewModel(
    private val repository: TimelineRepository = DefaultTimelineRepository(),
) : ViewModel() {

    var uiState by mutableStateOf(TimelineUiState())

    fun getTimeline() {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            val posts = repository.getTimeline()
            uiState = uiState.copy(posts = posts, isLoading = false)
        }
    }
}
