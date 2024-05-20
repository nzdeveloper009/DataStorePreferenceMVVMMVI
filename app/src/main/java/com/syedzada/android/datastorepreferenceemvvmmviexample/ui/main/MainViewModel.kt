package com.syedzada.android.datastorepreferenceemvvmmviexample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syedzada.android.datastorepreferenceemvvmmviexample.di.DIComponent
import com.syedzada.android.datastorepreferenceemvvmmviexample.model.Phonebook
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val diComponent by lazy {
        DIComponent()
    }

    private val _state = MutableLiveData<MainViewState>()
    val state: LiveData<MainViewState>
        get() = _state

    var name: MutableLiveData<String> = MutableLiveData("")
    var address: MutableLiveData<String> = MutableLiveData("")
    var phone: MutableLiveData<String> = MutableLiveData("")

    var phonebookName: MutableLiveData<String> = MutableLiveData("")
    var phonebookAddress: MutableLiveData<String> = MutableLiveData("")
    var phonebookPhone: MutableLiveData<String> = MutableLiveData("")

    fun processIntent(intent: MainIntent) {
        when (intent) {
            is MainIntent.SaveData -> saveData()
            MainIntent.LoadData -> loadData()
        }
    }

    private fun saveData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                diComponent.implRepository.savePhoneBook(
                    Phonebook(
                        name = name.toString(),
                        address = address.toString(),
                        phone = phone.toString()
                    )
                )
            } catch (e: Exception) {
                _state.value = MainViewState.Error(e.message ?: "Unknown error")
            }
        }
    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _state.value = MainViewState.Loading
                diComponent.implRepository.getPhoneBook().collect {
                    /*withContext(Dispatchers.Main) {
                        phonebook?.let {
                            phonebookName.value = it.name
                            phonebookAddress.value = it.address
                            phonebookPhone.value = it.phone
                            _state.value = MainViewState.DataLoaded(it)
                        }
                    }*/
                     it?.let { phonebook ->
                         phonebookName.postValue(phonebook.name)
                         phonebookAddress.postValue(phonebook.address)
                         phonebookPhone.postValue(phonebook.phone)
                         _state.value = MainViewState.DataLoaded(phonebook)
                     }
                }
            } catch (e: Exception) {
                _state.value = MainViewState.Error(e.message ?: "Unknown error")
            }
        }
    }
}