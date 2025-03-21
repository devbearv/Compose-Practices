package com.example.composepractices.ui.common.widgets

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.composepractices.ui.common.components.buttons.SampleIconButton
import com.example.composepractices.ui.theme.ComposePracticesTheme

@Composable
fun SampleChatInput(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
) {
    var input by remember { mutableStateOf(TextFieldValue("")) }

    Row(modifier = modifier) {
        BasicTextField(
            value = input,
            onValueChange = { input = it },
            textStyle = TextStyle(fontSize = 14.sp),
            decorationBox = { innerTextField ->
                if (input.text.isEmpty()) {
                    Text(
                        text = "Message"
                    )
                }
                innerTextField()
            }
        )
        SampleIconButton(
            icon = Icons.Filled.Send,
            onClick = {}
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun SampleChatInputLight() {
    ComposePracticesTheme(darkTheme = false) {
        SampleChatInput()
    }
}