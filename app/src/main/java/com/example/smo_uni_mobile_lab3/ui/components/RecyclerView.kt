package com.example.smo_uni_mobile_lab3.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smo_uni_mobile_lab3.R
import com.example.smo_uni_mobile_lab3.models.User
import com.example.smo_uni_mobile_lab3.state.MainActivityViewModel

@Composable
fun RecyclerView(vm: MainActivityViewModel = viewModel(), modifier: Modifier = Modifier) {
    val state by vm.state.collectAsStateWithLifecycle()

    if (state.loading) {
        MessageScreen(stringResource(R.string.loading))
    } else {
        if (state.list.isEmpty()) {
            MessageScreen(stringResource(R.string.empty_list))
        } else {
            LazyColumn(
                modifier = modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
            ) {
                items(state.list, itemContent = { item ->
                    ListItem(item, menuItems = { hideItemCallback ->
                        if (item is User) {
                            if (state.currentUser == item) {
                                DropdownMenuTextItem(
                                    text = stringResource(R.string.this_user_is_selected),
                                    true
                                )
                            } else {
                                DropdownMenuItem(text = {
                                    Text(
                                        stringResource(
                                            R.string.login_as,
                                            item.email
                                        )
                                    )
                                },
                                    onClick = {
                                        vm.loginAsUser(item)
                                    })
                            }
                        }
                        DropdownMenuItem(text = { Text(stringResource(R.string.delete)) },
                            onClick = {
                                vm.deleteItem(item)
                                hideItemCallback()
                            },
                            colors = MenuDefaults.itemColors(textColor = MaterialTheme.colorScheme.error),
                            enabled = item != state.currentUser
                        )
                    })
                })
            }
        }
    }
}
