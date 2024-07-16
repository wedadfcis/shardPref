package com.example.sharedprefrence.ui.theme.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun FormButton(
    text: String,
    modifier: Modifier,
    textStyle: TextStyle,
    textColor: Color,
    onClick: () -> Unit
) {
    Button(onClick = { onClick() }, shape = RoundedCornerShape(5.dp), modifier = modifier) {
        Text(text = text, style = textStyle, color = textColor, modifier = Modifier.padding(vertical = 8.dp))
    }

}