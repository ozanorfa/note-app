package com.task.noteapp.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.task.noteapp.R
import com.task.noteapp.databinding.SplashFragmentBinding
import com.task.noteapp.models.LottieModel
import com.task.noteapp.ui.base.BaseFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment() {

    private lateinit var binding: SplashFragmentBinding
    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[SplashViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SplashFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        val lottieModel = LottieModel(
            "loading_rainbow.json",
            getString(R.string.welcome),
            R.color.colorPrimary,
            25
        )
        viewModel.lottieModel.postValue(lottieModel)

        lifecycleScope.launch {
            delay(2000L)
            findNavController().navigate(R.id.noteListScreen)
        }

        return binding.root
    }


}