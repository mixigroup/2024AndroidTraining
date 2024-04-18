package jp.co.mixi.androidtraining.sns.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import jp.co.mixi.androidtraining.sns.data.entity.Post

@Composable
fun TimelineScreen(
    modifier: Modifier = Modifier,
) {
    val viewModel: TimelineViewModel = viewModel()
    val uiState = viewModel.uiState

    if (uiState.isLoading) {
        LoadingScreen(modifier = modifier)
    } else {
        Timeline(posts = uiState.posts, modifier = modifier)
    }

    // 初めてComposeされたときにブロック内の処理が実行されます
    LaunchedEffect(Unit) {
        viewModel.getTimeline()
    }
}

@Composable
private fun Timeline(
    posts: List<Post>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        items(posts) { post ->
            PostItem(
                post = post,
                modifier = Modifier.fillMaxWidth(),
            )
            HorizontalDivider()
        }
    }
}

@Composable
private fun LoadingScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator()
    }
}
