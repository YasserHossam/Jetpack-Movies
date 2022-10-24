package com.marvel.moviesapp.ui.composable

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable

@Composable
fun FavoriteDialog(
    onCancel: () -> Unit,
    onConfirm: () -> Unit,
    text: String,
    confirmButtonText: String
) {
    AlertDialog(
        onDismissRequest = onCancel,
        confirmButton = {
            TextButton(onClick = onConfirm)
            { Text(text = confirmButtonText) }
        },
        dismissButton = {
            TextButton(onClick = onCancel)
            { Text(text = "Cancel") }
        },
        text = { Text(text = text) }
    )
}