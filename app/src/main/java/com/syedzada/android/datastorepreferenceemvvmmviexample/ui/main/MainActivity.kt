package com.syedzada.android.datastorepreferenceemvvmmviexample.ui.main

import com.syedzada.android.datastorepreferenceemvvmmviexample.R
import com.syedzada.android.datastorepreferenceemvvmmviexample.databinding.ActivityMainBinding
import com.syedzada.android.datastorepreferenceemvvmmviexample.model.Phonebook
import com.syedzada.android.datastorepreferenceemvvmmviexample.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {


    override fun setupViews() {
        binding.viewModel = diComponent.phonebookViewModel
        binding.lifecycleOwner = this

        binding.btnSave.setOnClickListener {
            diComponent.phonebookViewModel.processIntent(
                MainIntent.SaveData
            )
        }

        binding.btnLoad.setOnClickListener {
            diComponent.phonebookViewModel.processIntent(
                MainIntent.LoadData
            )
        }
    }
}