package com.task.noteapp.ui.base

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import java.lang.Exception
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

open class BaseFragment() : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun getCurrentDateTime(): String{

        val pattern = "yyyy-MM-dd HH:mm"
        var dateTime = ""

        try {
            dateTime =  SimpleDateFormat(pattern, Locale.getDefault()).format(Date())
        }
        catch (e : Exception){
        }
        return dateTime
    }

}