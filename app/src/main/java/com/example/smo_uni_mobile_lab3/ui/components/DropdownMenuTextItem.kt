package com.example.smo_uni_mobile_lab3.ui.components

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun DropdownMenuTextItem(text: String, highlighted: Boolean) {
    DropdownMenuItem(text = {
        Text(
            text = text,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = if (highlighted)
                    MaterialTheme.colorScheme.primary
                else
                    MaterialTheme.colorScheme.inversePrimary
            )
        )
    }, enabled = false, onClick = {})
}
