package com.example.composepractices.practices.chapter2_layouts.ui.practice2_2_tagging_input_layout.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composepractices.practices.chapter2_layouts.data.models.TaggingInputUser

@Composable
fun TagUsersLayout(
    modifier: Modifier = Modifier,
    usersList: List<TaggingInputUser>,
    searchedText: String,
    onUserSelect: (TaggingInputUser) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.BottomStart)
    ) {
        items(
            items = usersList,
            key = { inputUser -> inputUser.id }
        ) { inputUser ->
            ItemUserRow(
                inputUser = inputUser,
                searchedText = searchedText,
                onUserSelect = onUserSelect
            )
        }
    }
}

@Composable
private fun ItemUserRow(
    modifier: Modifier = Modifier,
    inputUser: TaggingInputUser,
    searchedText: String,
    onUserSelect: (TaggingInputUser) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = inputUser.username
        )
    }
}