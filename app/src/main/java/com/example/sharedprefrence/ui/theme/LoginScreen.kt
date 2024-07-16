package com.example.sharedprefrence.ui.theme

import android.app.Activity.MODE_PRIVATE
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.sharedprefrence.R
import com.example.sharedprefrence.ui.theme.Constants.SharedPref.PASSWORD
import com.example.sharedprefrence.ui.theme.components.FormButton
import com.example.sharedprefrence.ui.theme.components.FormTextFiled

@Composable
fun LoginScreen(modifier: Modifier) {

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val sharedPreferences =
            LocalContext.current.getSharedPreferences(Constants.SharedPref.SHARD_NAME, MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        var name = sharedPreferences.getString(Constants.SharedPref.NAME, "")
        var password = sharedPreferences.getString(Constants.SharedPref.PASSWORD, "")

        FormTextFiled(
            value = name,
            placeholder = stringResource(id = R.string.user_name),
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .fillMaxWidth(),
            label = stringResource(id = R.string.user_name),
            hintStyle = MaterialTheme.typography.labelMedium,
            hintColor = MaterialTheme.colorScheme.onSecondary,
            keyboardOption = KeyboardOptions(keyboardType = KeyboardType.Text),
            textStyle = MaterialTheme.typography.labelSmall
        ) {
            name = it
        }
        Spacer(modifier = Modifier.height(16.dp))

        FormTextFiled(
            value = password,
            placeholder = stringResource(id = R.string.password),
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .fillMaxWidth(),
            label = stringResource(id = R.string.password),
            hintStyle = MaterialTheme.typography.labelMedium,
            hintColor = MaterialTheme.colorScheme.onSecondary,
            keyboardOption = KeyboardOptions(keyboardType = KeyboardType.Password),
            textStyle = MaterialTheme.typography.labelSmall
        ) {
            password = it
        }
        Spacer(modifier = Modifier.height(16.dp))

        FormButton(
            text = stringResource(id = R.string.login),
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyMedium,
            textColor = MaterialTheme.colorScheme.onSecondaryContainer
        ) {
            editor.putString(Constants.SharedPref.NAME,name)
            editor.putString(PASSWORD,password)
            editor.apply()
        }

    }
}
