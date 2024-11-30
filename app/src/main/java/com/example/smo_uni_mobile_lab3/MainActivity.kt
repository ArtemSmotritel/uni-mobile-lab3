package com.example.smo_uni_mobile_lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.smo_uni_mobile_lab3.db.AppDatabase
import com.example.smo_uni_mobile_lab3.state.MainActivityViewModel
import com.example.smo_uni_mobile_lab3.ui.component.RecyclerView
import com.example.smo_uni_mobile_lab3.ui.theme.Smounimobilelab3Theme

class MainActivity : ComponentActivity() {
    private val db by lazy { AppDatabase.getAppDatabase(applicationContext) }
    private lateinit var vm: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        vm = MainActivityViewModel(db.userDao(), db.postDao())

        setContent {
            Smounimobilelab3Theme {
                RecyclerView(vm)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Smounimobilelab3Theme {
    }
}
