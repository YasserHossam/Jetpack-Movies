package com.marvel.moviesapp.ui.composable

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable

@Composable
fun FavoriteDialog(onCancel: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
        onDismissRequest = onCancel,
        confirmButton = {
            TextButton(onClick = onConfirm)
            { Text(text = "Add") }
        },
        dismissButton = {
            TextButton(onClick = onCancel)
            { Text(text = "Cancel") }
        },
        text = { Text(text = "Add item to favorites?") }
    )
}