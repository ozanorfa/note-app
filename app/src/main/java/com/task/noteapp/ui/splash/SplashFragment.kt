package com.task.noteapp.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.task.noteapp.MainActivity
import com.task.noteapp.R
import com.task.noteapp.models.LottieModel
import com.task.noteapp.databinding.SplashFragmentBinding
import com.task.noteapp.ui.base.BaseFragment
import com.task.noteapp.ui.notelists.NoteListFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment() {

    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[SplashViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = SplashFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        val lottieModel = LottieModel("loading_rainbow.json", "Hoşgeldiniz", R.color.purple_500, 25)
        viewModel.lottieModel.postValue(lottieModel)

        lifecycleScope.launch {
            delay(3000L)
            (activity as MainActivity).replaceFragment(NoteListFragment(), "NoteList")
        }

        return binding.root

    }


}