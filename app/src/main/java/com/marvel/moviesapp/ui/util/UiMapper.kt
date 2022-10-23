package com.marvel.moviesapp.ui.util

interface UiMapper<UI, T> {
    fun mapToUiModel(model: T): UI

    fun mapFromUiModel(model: UI): T
}