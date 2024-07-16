package com.example.sharedprefrence.ui.theme.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation


@Composable
fun FormPasswordTextFiled(
    value: String?,
    modifier: Modifier,
    placeholder: String,
    label: String,
    hintStyle: TextStyle,
    hintColor: Color,
    keyboardOption: KeyboardOptions,
    textStyle: TextStyle,
    showPasswordIcon: Int,
    hidePasswordIcon: Int,
    onValueChanged: (String) -> Unit
) {
    var textFiledValue by remember {
        mutableStateOf(value)
    }
    var showPassword by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = textFiledValue?:"",
        modifier = modifier,
        onValueChange = {
            onValueChanged(it)
            textFiledValue = it
        },
        placeholder = { Text(text = placeholder, style = hintStyle, color = hintColor) },
        label = { Text(text = label) },
        keyboardOptions = keyboardOption,
        textStyle = textStyle,
        visualTransformation =
        if (showPassword) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        trailingIcon = {
            if (showPassword) {
                IconButton(onClick = { showPassword = false }) {
                    Icon(
                        painter = painterResource(id = showPasswordIcon),
                        contentDescription = "hide password"
                    )
                }
            } else {
                IconButton(onClick = { showPassword = true }) {
                    Icon(
                        painter = painterResource(id = hidePasswordIcon),
                        contentDescription = "show password"
                    )
                }
            }
        }
    )
}