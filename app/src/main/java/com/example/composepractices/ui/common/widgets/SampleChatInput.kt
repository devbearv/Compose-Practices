package com.example.composepractices.ui.common.widgets

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.tooling.preview.Preview
import com.example.composepractices.R
import com.example.composepractices.ui.common.components.buttons.SampleIconButton
import com.example.composepractices.ui.common.components.texfields.SampleTextField
import com.example.composepractices.ui.common.theme.DimensSampleChat
import com.example.composepractices.ui.theme.ComposePracticesTheme
import com.example.composepractices.ui.theme.Green400

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampleChatInput(
    modifier: Modifier = Modifier,
    input: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    val isEnabled = remember(input.text) { input.text.isNotBlank() }

//    val annotatedString = buildAnnotatedString {
//        append(input.text)
//        val mentionMatches = "@\\w+".toRegex().findAll(input.text)
//        mentionMatches.forEach { matchResult ->
//            addStyle(
//                style = SpanStyle(color = Green400, fontWeight = FontWeight.Bold),
//                start = matchResult.range.first,
//                end = matchResult.range.last + 1
//            )
//        }
//    }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(DimensSampleChat.cornerShape),
            color = MaterialTheme.colorScheme.secondaryContainer
        ) {
            SampleTextField(
                modifier = Modifier.padding(
                    horizontal = DimensSampleChat.paddingInternHorizontal,
                    vertical = DimensSampleChat.paddingInternVertical
                ),
                input = input,
                onValueChange = onValueChange,
                maxLines = 5,
                visualTransformation = { textFieldValue ->
                    val annotatedString = buildAnnotatedString {
                        append(textFieldValue.text)
                        val mentionMatches = "@\\w+".toRegex().findAll(textFieldValue.text)
                        mentionMatches.forEach { matchResult ->
                            addStyle(
                                style = SpanStyle(color = Green400, fontWeight = FontWeight.Bold),
                                start = matchResult.range.first,
                                end = matchResult.range.last + 1
                            )
                        }
                    }

                    TransformedText(
                        text = annotatedString,
                        offsetMapping = object : OffsetMapping {
                            override fun originalToTransformed(offset: Int): Int = offset
                            override fun transformedToOriginal(offset: Int): Int = offset
                        }
                    )
                },
                textStyle = TextStyle(
                    fontSize = DimensSampleChat.fontSize
                ),
                placeholder = {
                    Text(
                        text = stringResource(R.string.sample_chat_placeholder_1),
                        color = MaterialTheme.colorScheme.secondary
                    )
                },
                contentPadding = PaddingValues(DimensSampleChat.paddingValue)
            )
        }

        SampleIconButton(
            icon = Icons.Filled.Send,
            enabled = isEnabled,
            onClick = {}
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun SampleChatInputLight() {
    ComposePracticesTheme(darkTheme = false) {
        var input by remember { mutableStateOf(TextFieldValue(""))}
        SampleChatInput(
            input = input,
            onValueChange = { input = it }
        )
    }
}