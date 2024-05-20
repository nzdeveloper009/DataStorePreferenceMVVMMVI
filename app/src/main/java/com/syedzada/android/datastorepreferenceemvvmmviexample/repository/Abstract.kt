package com.syedzada.android.datastorepreferenceemvvmmviexample.repository

import com.syedzada.android.datastorepreferenceemvvmmviexample.model.Phonebook
import kotlinx.coroutines.flow.Flow

interface Abstract {
    suspend fun savePhoneBook(phonebook: Phonebook)
    fun getPhoneBook(): Flow<Phonebook?>
}