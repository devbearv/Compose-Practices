package com.example.composepractices.practices.chapter1_components.practice1_1_chat_message.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChatInput(
    modifier: Modifier = Modifier,
    onTextChange: (TextFieldValue) -> Unit
) {
    var input by remember { mutableStateOf(TextFieldValue("")) }

    Row() {
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            textStyle = TextStyle(
                fontSize = 18.sp
            ),
            value = input,
            onValueChange = onTextChange,
            maxLines = 6,
            cursorBrush = SolidColor(Color(0xff00897B)),
            decorationBox = { innerTextField ->
                innerTextField()
            }
        )
        IconButton(
            onClick = {}
        ) { }
    }
}