package com.example.smo_uni_mobile_lab3.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.example.smo_uni_mobile_lab3.R
import com.example.smo_uni_mobile_lab3.models.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(onReset: () -> Unit, onAddUser: () -> Unit, currentUser: User?) {
    var showMenu by remember { mutableStateOf(false) }

    TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
    ), title = {
        Text(stringResource(R.string.users_posts))
    }, actions = {
        IconButton(onClick = { showMenu = true }) {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = stringResource(R.string.menu)
            )
        }
        DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
            DropdownMenuTextItem(
                highlighted = currentUser != null,
                text = if (currentUser == null) stringResource(R.string.no_user_selected) else stringResource(
                    R.string.logged_in, currentUser.email
                )
            )
            DropdownMenuItem(text = { Text(stringResource(R.string.reset_items)) }, onClick = {
                showMenu = false
                onReset()
            })
            DropdownMenuItem(text = { Text(stringResource(R.string.add_user)) }, onClick = {
                showMenu = false
                onAddUser()
            })
        }
    })
}
