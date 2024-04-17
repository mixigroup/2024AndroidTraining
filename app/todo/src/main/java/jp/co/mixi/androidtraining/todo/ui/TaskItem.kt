package jp.co.mixi.androidtraining.todo.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import jp.co.mixi.androidtraining.todo.R
import jp.co.mixi.androidtraining.todo.data.entity.Task

@Composable
fun TaskItem(
    task: Task,
    onDeleteButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    ListItem(
        headlineContent = { Text(text = task.title) },
        modifier = modifier,
        trailingContent = {
            IconButton(onClick = onDeleteButtonClick) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = stringResource(id = R.string.delete),
                )
            }
        },
    )
}

@Preview
@Composable
private fun TaskItemPreview() {
    MaterialTheme {
        TaskItem(
            task = Task(title = "Task"),
            onDeleteButtonClick = {},
        )
    }
}
