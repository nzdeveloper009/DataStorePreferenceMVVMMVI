package com.syedzada.android.datastorepreferenceemvvmmviexample.ui.main

import com.syedzada.android.datastorepreferenceemvvmmviexample.model.Phonebook

sealed class MainViewState {
    data class DataLoaded(val phonebook: Phonebook) : MainViewState()
    object Loading : MainViewState()
    data class Error(val errorMessage: String) : MainViewState()
}