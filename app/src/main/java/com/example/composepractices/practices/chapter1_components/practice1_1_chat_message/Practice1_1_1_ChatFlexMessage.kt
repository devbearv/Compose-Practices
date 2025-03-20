package com.example.composepractices.practices.chapter1_components.practice1_1_chat_message

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractices.practices.chapter1_components.practice1_1_chat_message.widget.ChatFlexBoxLayout
import com.example.composepractices.practices.chapter1_components.practice1_1_chat_message.widget.ChatInput
import com.example.composepractices.ui.theme.Blue400
import com.example.composepractices.ui.theme.ComposePracticesTheme
import com.example.composepractices.ui.theme.Green400
import com.example.composepractices.ui.theme.Orange400
import com.example.composepractices.ui.theme.Pink400
import java.sql.Timestamp

data class ChatMessage(
    val message: String,
    val time: Timestamp = Timestamp(System.currentTimeMillis())
)

@Composable
fun Practice1_1_1_ChatFlexMessage() {
    val messages = remember { mutableStateListOf(
        ChatMessage("Single line message"),
        ChatMessage("Single line message exceeds threshold"),
        ChatMessage("Multiple line sample that exceeds that preview message")
    )}

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column(modifier = Modifier.padding(10.dp, 15.dp)) {
            Text(text = "Preview composable Chat Message Layout with ")
            Spacer(Modifier.height(20.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentPadding = PaddingValues(top = 8.dp, bottom = 8.dp)
            ) {
                items(messages) { message: ChatMessage ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(end = 60.dp, top = 2.dp, bottom = 2.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        MessageItem(text = message.message)
                    }
                }
            }

            ChatInput(onChangeMessage = {
                messages.add(
                    ChatMessage(
                        message = it,
                        time = Timestamp(System.currentTimeMillis())
                    )
                )
            })
        }
    }
}

@Composable
private fun MessageItem(text: String) {
    var color by remember {
        mutableStateOf(Orange400)
    }

    ChatFlexBoxLayout(
        modifier = Modifier
            .shadow(2.dp, shape = RoundedCornerShape(8.dp))
            .background(color, shape = RoundedCornerShape(8.dp))
            .padding(start = 2.dp, top = 2.dp, end = 4.dp, bottom = 2.dp),
        text = text,
        messageStat = {
            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .background(Color.Yellow),
                text = "hh:mmm"
            )
        },
        onMeasure = { chatRowData ->
            color = when (chatRowData.measuredType) {
                0 -> Orange400
                1 -> Blue400
                2 -> Green400
                else -> Pink400
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
private fun Practice1_1_1_ChatFlexMessageLight() {
    ComposePracticesTheme {
        Practice1_1_1_ChatFlexMessage()
    }
}