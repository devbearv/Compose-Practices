package com.example.composepractices.ui.common.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractices.ui.theme.ComposePracticesTheme
import com.example.composepractices.ui.theme.Dimens
import com.example.composepractices.ui.theme.Green400

/** Generated JSDocs with AI */

/**
 * A button with an icon, wrapped in a Card for styling.
 *
 * @param modifier The modifier to be applied to the card.
 * @param shape The shape of the card.
 * @param colors The colors of the card.
 * @param elevation The elevation of the card.
 * @param border The border of the card.
 * @param enabled Whether the button is enabled.
 * @param onClick The action to perform when the button is clicked.
 * @param icon The icon to display inside the button.
 * @param contentDescription A description of the icon for accessibility.
 */
@Composable
fun <GenericIcon> SampleIconButton(
    modifier: Modifier = Modifier,
    icon: GenericIcon,
    contentDescription: String? = null,
    shape: Shape = CircleShape,
    colors: CardColors = CardDefaults.cardColors(),
    elevation: CardElevation = CardDefaults.cardElevation(),
    border: BorderStroke? = null,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        enabled = enabled,
        onClick = onClick
    ) {
        ConvertedIcon(
            modifier = Modifier.padding(Dimens.paddingSampleIconButton),
            icon = icon,
            contentDescription = contentDescription
        )
    }
}

/**
 * A customizable icon button that accepts different types of icons.
 *
 * @param modifier The modifier to be applied to the button.
 * @param icon The icon to display inside the button. Can be a drawable resource ID (Int),
 * an ImageVector, or a Painter.
 * @param contentDescription A description of the icon for accessibility.
 * @param enabled Whether the button is enabled.
 * @param colors The color scheme of the button.
 * @param interactionSource The interaction source for touch feedback.
 * @param onClick The action to perform when the button is clicked.
 */
@Composable
fun <GenericIcon> SampleIconButton(
    modifier: Modifier = Modifier,
    icon: GenericIcon,
    contentDescription: String? = null,
    enabled: Boolean = true,
    colors: IconButtonColors = IconButtonDefaults.iconButtonColors(),
    interactionSource: MutableInteractionSource? = null,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        interactionSource = interactionSource,
        onClick = onClick
    ) {
        ConvertedIcon(
            icon = icon,
            contentDescription = contentDescription
        )
    }
}

/**
 * Converts a generic icon type into a Compose-compatible Icon.
 *
 * @param modifier The modifier to be applied to the icon.
 * @param icon The icon to be converted. Can be a drawable resource ID (Int),
 * an ImageVector, or a Painter.
 * @param contentDescription A description of the icon for accessibility.
 *
 * @throws IllegalArgumentException If the provided icon type is not supported.
 */
@Composable
private fun <Icon> ConvertedIcon(
    modifier: Modifier = Modifier,
    icon: Icon,
    contentDescription: String? = null
) {
    when (icon) {
        is Int -> Icon(
            modifier = modifier,
            painter = painterResource(icon),
            contentDescription = contentDescription
        )
        is ImageVector -> Icon(
            modifier = modifier,
            imageVector = icon,
            contentDescription = contentDescription
        )
        is Painter -> Icon(
            modifier = modifier,
            painter = icon,
            contentDescription = contentDescription
        )
        else -> throw IllegalArgumentException("Unsupported icon type")
    }
}

@Composable
@Preview(showBackground = true)
private fun SampleIconButtonLight() {
    ComposePracticesTheme(darkTheme = false) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            SampleIconButton(
                icon = Icons.Filled.Edit,
                colors = CardDefaults.cardColors(
                    containerColor = Green400,
                    contentColor = Color.White
                ),
                onClick = {}
            )
            SampleIconButton(
                icon = Icons.Filled.Edit,
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Green400,
                    contentColor = Color.White
                ),
                onClick = {}
            )
        }
    }
}