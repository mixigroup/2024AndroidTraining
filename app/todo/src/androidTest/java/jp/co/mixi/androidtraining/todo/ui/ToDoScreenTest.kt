package jp.co.mixi.androidtraining.todo.ui

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class ToDoScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testInputText() {
        composeTestRule.setContent {
            ToDoScreen()
        }

        val textFieldTag = "TaskTextField"
        val task = "レッスンの予約"

        composeTestRule
            .onNodeWithTag(textFieldTag)
            .performTextInput(task)

        composeTestRule
            .onNodeWithTag(textFieldTag)
            .assert(hasText(task))
    }

    @Test
    fun testAddTask() {
        composeTestRule.setContent {
            ToDoScreen()
        }

        val textFieldTag = "TaskTextField"
        val taskListTag = "TaskList"
        val task = "レッスンの予約"

        composeTestRule
            .onNodeWithTag(textFieldTag)
            .performTextInput(task)

        composeTestRule
            .onNodeWithContentDescription("追加")
            .performClick()

        composeTestRule
            .onNodeWithTag(taskListTag)
            .onChildren()
            .onFirst()
            .assert(hasText(task))
    }
}
