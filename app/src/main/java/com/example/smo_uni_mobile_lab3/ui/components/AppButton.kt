package com.example.smo_uni_mobile_lab3.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppButton(modifier: Modifier = Modifier, onClick: () -> Unit, colors: ButtonColors, text: String) {
    Button(
        onClick = onClick,
        modifier = modifier.padding(8.dp),
        colors = colors
    ) {
        Text(text)
    }
}