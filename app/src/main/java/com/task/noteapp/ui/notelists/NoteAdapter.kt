package com.task.noteapp.ui.notelists

import com.task.noteapp.R
import com.task.noteapp.data.note.Note
import com.task.noteapp.databinding.ItemNoteBinding
import com.task.noteapp.ui.base.BaseAdapter
import com.task.noteapp.ui.base.BaseViewHolder

class NoteAdapter(
    list: List<Note>,
    val noteClickInterface: NoteClickInterface,
) : BaseAdapter<ItemNoteBinding, Note>(list) {

    override val layoutId: Int = R.layout.item_note

    override fun bind(binding: ItemNoteBinding, item: Note) {
        binding.apply {
            model = item
            executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ItemNoteBinding>, position: Int) {
        super.onBindViewHolder(holder, position)

        holder.itemView.setOnClickListener {
            noteClickInterface.onNoteClick(data[position])
        }
        holder.binder.btnDel.setOnClickListener {
            noteClickInterface.onNoteDelete(data[position])
        }
    }
}

interface NoteClickInterface {
    fun onNoteClick(any: Note)
    fun onNoteDelete(any : Note)
}