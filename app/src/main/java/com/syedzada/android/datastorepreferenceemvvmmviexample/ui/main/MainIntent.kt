package com.syedzada.android.datastorepreferenceemvvmmviexample.ui.main


sealed class MainIntent {
    data object SaveData : MainIntent()
    data object LoadData : MainIntent()
}