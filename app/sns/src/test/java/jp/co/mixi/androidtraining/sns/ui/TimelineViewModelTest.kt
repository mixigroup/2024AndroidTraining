package jp.co.mixi.androidtraining.sns.ui

import jp.co.mixi.androidtraining.sns.data.entity.Post
import jp.co.mixi.androidtraining.sns.data.entity.User
import jp.co.mixi.androidtraining.sns.data.repository.FakeTimelineRepository
import jp.co.mixi.androidtraining.sns.utils.MainDispatcherRule
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Rule
import org.junit.Test

class TimelineViewModelTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private val fakeTimeline = listOf(
        Post(author = User(name = "User Name", photoUrl = ""), content = "Content"),
    )

    private val viewModel = TimelineViewModel(FakeTimelineRepository(fakeTimeline))

    @Test
    fun testGetTimeline() = runTest {
        assertEquals(emptyList<Post>(), viewModel.uiState.posts)
        viewModel.getTimeline()
        advanceUntilIdle()
        assertEquals(fakeTimeline, viewModel.uiState.posts)
        assertFalse(viewModel.uiState.isLoading)
    }
}
