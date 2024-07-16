package com.example.sharedprefrence.ui.theme.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle


@Composable
fun FormTextFiled(
    value: String?,
    modifier: Modifier = Modifier,
    placeholder: String,
    label: String,
    hintStyle: TextStyle,
    hintColor: Color,
    keyboardOption: KeyboardOptions,
    textStyle: TextStyle,
    onValueChanged: (String) -> Unit
) {
    var textFiledValue by remember {
        mutableStateOf(value)
    }
    OutlinedTextField(
        value = textFiledValue?:"",
        modifier = modifier,
        onValueChange = {
            textFiledValue = it
            onValueChanged(it)
        },
        label = { Text(text = label) }, // floating label
        placeholder = { Text(text = placeholder, style = hintStyle, color = hintColor) },
        keyboardOptions = keyboardOption,
        textStyle = textStyle
    )
}