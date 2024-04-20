package jp.co.mixi.androidtraining.todo.ui

import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import jp.co.mixi.androidtraining.todo.data.entity.Task

@Composable
fun TaskItem(
    task: Task,
    modifier: Modifier = Modifier,
) {
    ListItem(
        headlineContent = { Text(text = task.title) },
        modifier = modifier,
    )
}

@Preview
@Composable
private fun TaskItemPreview() {
    MaterialTheme {
        TaskItem(task = Task(title = "Task"))
    }
}
