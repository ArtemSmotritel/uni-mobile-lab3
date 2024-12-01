package com.example.smo_uni_mobile_lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.smo_uni_mobile_lab3.db.AppDatabase
import com.example.smo_uni_mobile_lab3.state.MainActivityViewModel
import com.example.smo_uni_mobile_lab3.ui.components.AddUserForm
import com.example.smo_uni_mobile_lab3.ui.components.AppTopBar
import com.example.smo_uni_mobile_lab3.ui.components.RecyclerView
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
                MainContent(vm)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(vm: MainActivityViewModel) {
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        AppTopBar(onReset = { vm.reset() }, onAddUser = { showBottomSheet = true })
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Row(modifier = Modifier.weight(1f)) {
                RecyclerView(vm)
            }
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState
            ) {
                AddUserForm(onSubmit = {
                    vm.addUser(it)
                    showBottomSheet = false
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Smounimobilelab3Theme {}
}
