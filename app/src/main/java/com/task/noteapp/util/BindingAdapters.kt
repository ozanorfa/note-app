package com.task.noteapp.util

import android.content.res.ColorStateList
import android.graphics.Canvas
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.*
import com.task.noteapp.ui.base.BaseAdapter


@BindingAdapter("android:textColorId")
fun TextView.setTextColorValue(@ColorRes textColorId: Int) {
    if (textColorId == 0) return
    setTextColor(ContextCompat.getColor(context, textColorId))
}

@BindingAdapter("android:textSizeMan")
fun bindTextSize(textView: TextView, size: Int) {
    textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, size.toFloat())
}
@BindingAdapter("android:backgroundTint")
fun View.setTint(color: Int) = ViewCompat.setBackgroundTintList(
    this,
    ColorStateList.valueOf(ContextCompat.getColor(context, color))
)

@BindingAdapter("setAdapter")
fun setAdapter(
    recyclerView: RecyclerView,
    adapter: BaseAdapter<ViewDataBinding, Any>?
) {
    adapter?.let {
        recyclerView.adapter = it
    }
}

@Suppress("UNCHECKED_CAST")
@BindingAdapter("list")
fun submitList(recyclerView: RecyclerView, list: List<Any>?) {
    val adapter = recyclerView.adapter as BaseAdapter<ViewDataBinding, Any>?
    adapter?.updateData(list ?: listOf())
}
