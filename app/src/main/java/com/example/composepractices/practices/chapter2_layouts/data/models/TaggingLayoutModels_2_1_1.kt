package com.example.composepractices.practices.chapter2_layouts.data.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList

data class TaggingMessageState(
    val message: String = "",
    val filteredUsers: List<TaggingInputUser>,
    val prevMentionedUsers: SnapshotStateList<String> = mutableStateListOf(),
    val mentionedUser: MutableState<String> = mutableStateOf(""),
    val showUserList: Boolean = false
)

data class TaggingInputUser(
    val id: String,
    val fullName: String,
    val username: String
)