package com.task.noteapp.ui.notelists

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.task.noteapp.MainActivity
import com.task.noteapp.R
import com.task.noteapp.databinding.NoteListFragmentBinding
import com.task.noteapp.ui.addnote.NoteType
import com.task.noteapp.ui.base.BaseFragment

class NoteListFragment : BaseFragment() {

    private lateinit var binding: NoteListFragmentBinding
    private lateinit var viewModel: NoteListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       viewModel = ViewModelProvider(this,ViewModelFactoryNoteList((activity as MainActivity).application))[NoteListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NoteListFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.vm = viewModel
        binding.adapter = NoteAdapter(listOf())

        binding.fabAdd.setOnClickListener {
            val bundle = bundleOf("type" to NoteType.NEW,"title" to "", "description" to "")
            findNavController().navigate(R.id.addNoteScreen, bundle)
        }

        return binding.root
    }
}

class ViewModelFactoryNoteList(private val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteListViewModel(app) as T
    }
}