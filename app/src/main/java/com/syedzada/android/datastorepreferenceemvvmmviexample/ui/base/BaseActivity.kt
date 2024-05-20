package com.syedzada.android.datastorepreferenceemvvmmviexample.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.syedzada.android.datastorepreferenceemvvmmviexample.di.DIComponent

abstract class BaseActivity<T : ViewDataBinding>(@LayoutRes private val layoutId: Int) :
    AppCompatActivity() {
    private val baseTAG = "BaseTAG"

    private lateinit var _binding: T
    protected val binding: T
        get() = _binding


    protected val diComponent by lazy { DIComponent() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, layoutId)
        setupViews()
    }

    abstract fun setupViews() // Abstract function to set up views

    override fun onDestroy() {
        super.onDestroy()
        _binding.unbind() // Unbind the binding to avoid memory leaks
    }

}