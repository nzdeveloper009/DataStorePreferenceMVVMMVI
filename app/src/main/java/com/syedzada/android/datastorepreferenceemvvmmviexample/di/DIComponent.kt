package com.syedzada.android.datastorepreferenceemvvmmviexample.di

import com.syedzada.android.datastorepreferenceemvvmmviexample.repository.ImplRepository
import com.syedzada.android.datastorepreferenceemvvmmviexample.ui.main.MainViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DIComponent: KoinComponent {
     val phonebookViewModel by inject<MainViewModel>()
     val implRepository by inject<ImplRepository>()
}