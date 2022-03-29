package com.task.noteapp.ui.addnote

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.task.noteapp.MainActivity
import com.task.noteapp.R
import com.task.noteapp.databinding.AddNewNoteFragmentBinding
import com.task.noteapp.ui.base.BaseFragment
import com.task.noteapp.util.displayWarningDialog

class AddNewNoteFragment : BaseFragment() {

    private lateinit var binding: AddNewNoteFragmentBinding
    private lateinit var viewModel: AddNewNoteViewModel
    private val args: AddNewNoteFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(
            this, ViewModelFactoryNewNote((activity as MainActivity).application)
        )[AddNewNoteViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddNewNoteFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        viewModel.description.postValue(args.description)
        viewModel.title.postValue(args.title)
        viewModel.type.postValue(args.type)
        viewModel.noteID.postValue(args.noteId)

        binding.btnAddNote.setOnClickListener { it ->

            val title = binding.etTitle.text.toString().trim()
            val desc = binding.etDesc.text.toString().trim()

            if (title.isNotEmpty() && desc.isNotEmpty()) {
                val timeStamp = getCurrentDateTime()
                viewModel.saveItem(title, desc, timeStamp)
                findNavController().navigateUp()
            } else {
                displayWarningDialog(
                    activity as MainActivity,
                    getString(R.string.warning),
                    getString(R.string.fill_fields)
                )
            }

        }

        return binding.root
    }
}

class ViewModelFactoryNewNote(private val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddNewNoteViewModel(app) as T
    }
}
