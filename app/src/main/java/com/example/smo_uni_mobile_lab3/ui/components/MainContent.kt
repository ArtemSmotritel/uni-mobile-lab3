package com.example.smo_uni_mobile_lab3.ui.components

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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.smo_uni_mobile_lab3.state.MainActivityViewModel
import kotlinx.coroutines.flow.map

enum class BottomSheetModalType {
    NONE, ADD_USER, ADD_POST,
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(vm: MainActivityViewModel) {
    val currentUser by vm.state.map { it.currentUser }.collectAsStateWithLifecycle(null)
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }
    var bottomSheetModalType by remember { mutableStateOf(BottomSheetModalType.NONE) }

    val closeBottomSheet = { showBottomSheet = false; bottomSheetModalType = BottomSheetModalType.NONE }

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        AppTopBar(
            onReset = { vm.reset() },
            onAddUser = {
                showBottomSheet = true; bottomSheetModalType = BottomSheetModalType.ADD_USER
            },
            onAddPost = {
                showBottomSheet = true; bottomSheetModalType = BottomSheetModalType.ADD_POST
            },
            currentUser = currentUser
        )
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
                    closeBottomSheet()
                }, sheetState = sheetState
            ) {
                if (bottomSheetModalType == BottomSheetModalType.ADD_USER) {
                    AddUserForm(onSubmit = {
                        vm.addItem(it)
                        closeBottomSheet()
                    })
                } else if (bottomSheetModalType == BottomSheetModalType.ADD_POST) {
                    AddPostForm(onSubmit = {
                        vm.addItem(it)
                        closeBottomSheet()
                    }, currentUser = currentUser)
                }
            }
        }
    }
}
