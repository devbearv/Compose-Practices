package com.example.composepractices.practices.chapter2_layouts.ui.practice2_2_tagging_input_layout

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.composepractices.practices.chapter2_layouts.data.models.TaggingInputUser
import com.example.composepractices.practices.chapter2_layouts.data.models.TaggingMessageState
import com.example.composepractices.practices.chapter2_layouts.data.repository.TaggingInputRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TaggingLayoutViewModel @Inject constructor(
    private val taggingInputRepository: TaggingInputRepository
) : ViewModel() {

    private val _inputState = MutableStateFlow(TaggingMessageState(
        filteredUsers = taggingInputRepository.getAllUsers()))
    val inputState: StateFlow<TaggingMessageState> = _inputState.asStateFlow()

    fun onMessageChange(input: String) {
        Log.d("taggingLayout", "Received message = $input")
        Log.d("taggingLayout", "Current message = ${_inputState.value.message}")


        _inputState.update { currentState ->
            val lastAtIndex = input.lastIndexOf("@")
            val showUserList = if (lastAtIndex != -1) {
                val textAfterAt = input.substring(lastAtIndex + 1)
                !textAfterAt.contains(" ")
            } else false
            currentState.copy(
                message = input,
                showUserList = showUserList
            )
        }

        Log.d("taggingLayout", "Final message = ${_inputState.value.message}")

        filteredUsers()
    }

    private fun filteredUsers() {
        val lastAtIndex = _inputState.value.message.lastIndexOf("@")
        if (lastAtIndex != -1) {
            val textAfterAt = _inputState.value.message.substring(lastAtIndex + 1)
            _inputState.update { currentState ->
                currentState.copy(
                    filteredUsers = taggingInputRepository.getAllUsers().filter { user ->
                        user.username !in currentState.prevMentionedUsers &&
                                user.username.contains(textAfterAt, ignoreCase = true)
                    }
                )
            }
        }
    }

    fun onSelectUser(taggingInputUser: TaggingInputUser) {
        _inputState.update { currentState ->
            currentState.copy(
                message = currentState.message.substringBeforeLast("@") + "@" + taggingInputUser.username + " ",
                mentionedUser = mutableStateOf(taggingInputUser.username),
                prevMentionedUsers = currentState.prevMentionedUsers.apply {
                    add(taggingInputUser.username)
                },
                showUserList = false
            )
        }
    }

}