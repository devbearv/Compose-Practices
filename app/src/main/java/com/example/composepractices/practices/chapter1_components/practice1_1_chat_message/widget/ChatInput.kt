package com.example.composepractices.practices.chapter1_components.practice1_1_chat_message.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChatInput(
    modifier: Modifier = Modifier,
    onChangeMessage: (String) -> Unit
) {
    var input by remember { mutableStateOf(TextFieldValue("")) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            modifier = Modifier
                .weight(1f) // Permite que o campo ocupe apenas o espaço necessário
                .padding(vertical = 4.dp),
            textStyle = TextStyle(fontSize = 18.sp),
            value = input,
            onValueChange = { input = it },
            maxLines = 6,
            cursorBrush = SolidColor(Color(0xff00897B)),
            decorationBox = { innerTextField ->
                innerTextField()
            }
        )

        IconButton(
            onClick = { onChangeMessage(input.text) }
        ) {
            Icon(
                imageVector = Icons.Filled.Send,
                tint = Color.Red,
                contentDescription = null
            )
        }
    }
}