package com.task.noteapp.ui.splash

import androidx.lifecycle.MutableLiveData
import com.task.noteapp.models.LottieModel
import com.task.noteapp.ui.base.BaseViewModel

class SplashViewModel : BaseViewModel() {

    var lottieModel = MutableLiveData<LottieModel>()


    override fun onCleared() {
        super.onCleared()
    }
}