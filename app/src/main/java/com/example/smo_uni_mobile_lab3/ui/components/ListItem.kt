package com.example.smo_uni_mobile_lab3.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.smo_uni_mobile_lab3.R
import com.example.smo_uni_mobile_lab3.models.IListItem

@Composable
fun ListItem(item: IListItem, onDeleteClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 5.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(CornerSize(10.dp)),
        elevation = CardDefaults.elevatedCardElevation()
    ) {
        Row(modifier = Modifier.padding(5.dp)) {
            item.imageUrl()?.let { imageUrl ->
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageUrl)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_launcher_background),
                    error = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = "\"${item.title()}\" photo",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(60.dp)
                        .clip(RoundedCornerShape(CornerSize(6.dp)))
                        .align(alignment = Alignment.CenterVertically)
                )
            }

            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = item.title(),
                        modifier = Modifier
                            .padding(10.dp, 20.dp, 10.dp, 0.dp)
                            .fillMaxWidth(0.5f)
                    )
                    Text(
                        text = item.id(),
                        modifier = Modifier.padding(10.dp, 20.dp, 10.dp, 0.dp),
                        fontSize = 10.sp
                    )
                    AppButton(
                        onClick = onDeleteClick,
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.errorContainer),
                        text = stringResource(R.string.delete)
                    )
                }
                item.description()?.let { description ->
                    Text(
                        text = description,
                        modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 20.dp),
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}
