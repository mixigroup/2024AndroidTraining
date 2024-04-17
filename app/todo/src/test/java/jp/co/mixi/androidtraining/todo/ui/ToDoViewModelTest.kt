package jp.co.mixi.androidtraining.todo.ui

import jp.co.mixi.androidtraining.todo.data.entity.Task
import org.junit.Assert.assertEquals
import org.junit.Test

class ToDoViewModelTest {

    private val viewModel = ToDoViewModel()

    @Test
    fun testInputText() {
        viewModel.setInputText("text")
        assertEquals("text", viewModel.uiState.inputText)
    }

    @Test
    fun testAddTask() {
        viewModel.setInputText("text")
        viewModel.addTask()
        assertEquals(listOf(Task("text")), viewModel.uiState.tasks)
    }
}
