package com.example.composepractices.practices.chapter2_layouts.ui.practice2_2_tagging_input_layout

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.composepractices.practices.chapter2_layouts.data.models.TaggingInputUser
import com.example.composepractices.practices.chapter2_layouts.data.models.TaggingMessageState
import com.example.composepractices.practices.chapter2_layouts.ui.practice2_2_tagging_input_layout.components.TagUsersLayout
import com.example.composepractices.ui.common.widgets.SampleChatInput
import com.example.composepractices.ui.theme.ComposePracticesTheme
import com.example.composepractices.ui.theme.Green400

@Composable
fun Practice2_1_1_TaggingInputLayout(
    taggingLayoutViewModel: TaggingLayoutViewModel = hiltViewModel()
) {
    val taggingMessageState by taggingLayoutViewModel.inputState.collectAsStateWithLifecycle()

    Content(
        taggingMessageState = taggingMessageState,
        onValueChange = {
            taggingLayoutViewModel.onMessageChange(it.text)
        },
        onSelectUser = taggingLayoutViewModel::onSelectUser
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Content(
    modifier: Modifier = Modifier,
    taggingMessageState: TaggingMessageState,
    onValueChange: (TextFieldValue) -> Unit,
    onSelectUser: (TaggingInputUser) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Tagging Input Layout",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .imePadding()
                    .systemBarsPadding()
            ) {
                SampleChatInput(
                    modifier = Modifier.padding(10.dp),
                    input = TextFieldValue(
                        text = taggingMessageState.message,
                        selection = TextRange(taggingMessageState.message.length)
                    ),
                    onValueChange = onValueChange
                )
            }
        },
        containerColor = MaterialTheme.colorScheme.surface,
        contentWindowInsets = WindowInsets.safeDrawing
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
        ) {
            AnimatedVisibility(
                modifier = Modifier.align(Alignment.BottomCenter),
                visible = taggingMessageState.showUserList,
            ) {
                TagUsersLayout(
                    usersList = taggingMessageState.filteredUsers,
                    searchedText = taggingMessageState.message.substringAfterLast("@"),
                    onUserSelect = onSelectUser
                )
            }
        }
    }
}

