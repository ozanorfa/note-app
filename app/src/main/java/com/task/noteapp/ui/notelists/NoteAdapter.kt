package com.task.noteapp.ui.notelists

import com.task.noteapp.R
import com.task.noteapp.data.note.Note
import com.task.noteapp.databinding.ItemNoteBinding
import com.task.noteapp.ui.base.BaseAdapter

class NoteAdapter(
    private val list: List<Note>,
) : BaseAdapter<ItemNoteBinding, Note>(list) {

    override val layoutId: Int = R.layout.item_note

    override fun bind(binding: ItemNoteBinding, item: Note) {
        binding.apply {
            model = item
            executePendingBindings()
        }
    }
}