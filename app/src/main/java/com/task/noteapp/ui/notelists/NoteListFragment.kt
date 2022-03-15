package com.task.noteapp.ui.notelists

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.task.noteapp.R
import com.task.noteapp.databinding.NoteListFragmentBinding
import com.task.noteapp.databinding.SplashFragmentBinding
import com.task.noteapp.ui.splash.SplashViewModel

class NoteListFragment : Fragment() {


    private lateinit var viewModel: NoteListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[NoteListViewModel::class.java]

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