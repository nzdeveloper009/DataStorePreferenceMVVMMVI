package com.syedzada.android.datastorepreferenceemvvmmviexample.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.syedzada.android.datastorepreferenceemvvmmviexample.model.Phonebook
import kotlinx.coroutines.flow.map

const val DataStore_NAME = "PHONEBOOK"
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = DataStore_NAME)

class ImplRepository(private val context: Context) : Abstract {
    companion object {
        val NAME_KEY = stringPreferencesKey("NAME")
        val ADDRESS_KEY = stringPreferencesKey("ADDRESS")
        val PHONE_KEY = stringPreferencesKey("PHONE")
    }

    override suspend fun savePhoneBook(phonebook: Phonebook) {
        context.dataStore.edit { preferences ->
            preferences[NAME_KEY] = phonebook.name
            preferences[ADDRESS_KEY] = phonebook.address
            preferences[PHONE_KEY] = phonebook.phone
        }
    }

    override fun getPhoneBook() = context.dataStore.data.map {preferences ->
        Phonebook(
            name = preferences[NAME_KEY] ?: return@map null,
            address = preferences[ADDRESS_KEY] ?: return@map null,
            phone = preferences[PHONE_KEY] ?: return@map null
        )
    }
}