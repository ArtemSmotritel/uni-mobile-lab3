package com.example.smo_uni_mobile_lab3.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.smo_uni_mobile_lab3.R
import com.example.smo_uni_mobile_lab3.models.Post
import com.example.smo_uni_mobile_lab3.models.PostBuilder
import com.example.smo_uni_mobile_lab3.models.User

@Composable
fun AddPostForm(onSubmit: (Post) -> Unit, currentUser: User?) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var imageUrl by remember { mutableStateOf("") }

    if (currentUser == null) {
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = stringResource(R.string.post_form), style = MaterialTheme.typography.titleLarge)
        Text(
            text = stringResource(R.string.post_author, currentUser.email),
            style = MaterialTheme.typography.bodyLarge
        )

        OutlinedTextField(value = title,
            onValueChange = { title = it },
            label = { Text(stringResource(R.string.title)) },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(value = content,
            onValueChange = { content = it },
            label = { Text(stringResource(R.string.content)) },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(value = imageUrl,
            onValueChange = { imageUrl = it },
            label = { Text(stringResource(R.string.image_url)) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Uri)
        )

        Button(
            onClick = {
                val post = PostBuilder()
                    .title(title)
                    .content(content)
                    .imageUrl(imageUrl)
                    .userId(currentUser.id)
                    .build()
                onSubmit(post)
            }, modifier = Modifier.align(Alignment.End)
        ) {
            Text(stringResource(R.string.create))
        }
    }
}
