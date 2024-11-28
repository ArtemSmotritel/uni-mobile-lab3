package com.example.smo_uni_mobile_lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.smo_uni_mobile_lab3.models.fakeData
import com.example.smo_uni_mobile_lab3.models.tripleFakeData
import com.example.smo_uni_mobile_lab3.ui.component.RecyclerView
import com.example.smo_uni_mobile_lab3.ui.theme.Smounimobilelab3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Smounimobilelab3Theme {
                RecyclerView(tripleFakeData())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Smounimobilelab3Theme {
        RecyclerView(fakeData())
    }
}
