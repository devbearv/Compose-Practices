package com.example.composepractices.domain.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import com.example.composepractices.ui.theme.Green400

@Composable
fun String.usersAnnotatedString(): AnnotatedString {
    val text = this
    val annotatedString = buildAnnotatedString {
        append(text)
        val mentionMatches = "@\\w+".toRegex().findAll(text)
        mentionMatches.forEach { matchResult ->
            addStyle(
                style = SpanStyle(color = Green400),
                start = matchResult.range.first,
                end = matchResult.range.last + 1
            )
        }
    }
    return annotatedString
}