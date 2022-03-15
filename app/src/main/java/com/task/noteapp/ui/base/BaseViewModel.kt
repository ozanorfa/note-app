package com.task.noteapp.ui.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {


    protected fun setViewDataBinding(viewBinding: ViewDataBinding) {

    }

    override fun onCleared() {
        super.onCleared()

    }

}