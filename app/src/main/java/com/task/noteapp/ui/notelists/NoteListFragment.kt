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
import com.task.noteapp.data.note.Note
import com.task.noteapp.databinding.NoteListFragmentBinding
import com.task.noteapp.ui.addnote.NoteType
import com.task.noteapp.ui.base.BaseFragment

class NoteListFragment : BaseFragment(), NoteClickInterface {

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
        binding.adapter = NoteAdapter(listOf(), this)

        binding.fabAdd.setOnClickListener {
            val bundle = bundleOf("type" to NoteType.NEW, "title" to "", "description" to "", "noteId" to 0)
            findNavController().navigate(R.id.addNoteScreen, bundle)
        }

        return binding.root
    }

    override fun onNoteClick(any: Note) {
        val bundle = bundleOf("type" to NoteType.CHANGE, "title" to any.noteTitle, "description" to any.noteDescription, "noteId" to any.id)
        findNavController().navigate(R.id.addNoteScreen, bundle)
    }

    override fun onNoteDelete(any: Note) {
        viewModel.deleteNote(any)
    }
}

class ViewModelFactoryNoteList(private val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteListViewModel(app) as T
    }
}