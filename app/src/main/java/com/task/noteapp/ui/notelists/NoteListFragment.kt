package com.task.noteapp.ui.notelists

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.task.noteapp.MainActivity
import com.task.noteapp.R
import com.task.noteapp.databinding.NoteListFragmentBinding
import com.task.noteapp.databinding.SplashFragmentBinding
import com.task.noteapp.ui.splash.SplashViewModel

class NoteListFragment : Fragment() {

    private lateinit var viewModel: NoteListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       viewModel = ViewModelProvider(this,ViewModelFactory((activity as MainActivity).application))[NoteListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = NoteListFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        return binding.root
    }
}

class ViewModelFactory(private val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteListViewModel(app) as T
    }
}