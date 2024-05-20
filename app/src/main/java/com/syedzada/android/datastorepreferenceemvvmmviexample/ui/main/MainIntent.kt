package com.syedzada.android.datastorepreferenceemvvmmviexample.ui.main

import com.syedzada.android.datastorepreferenceemvvmmviexample.model.Phonebook

sealed class MainIntent {
    data class SaveData(val phonebook: Phonebook) : MainIntent()
    object LoadData : MainIntent()
}