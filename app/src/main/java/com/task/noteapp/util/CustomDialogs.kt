package com.task.noteapp.util

import android.app.Activity
import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeErrorDialog
import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeProgressDialog
import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeSuccessDialog
import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeWarningDialog
import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure
import com.task.noteapp.R

fun displayErrorDialog(activity: Activity, title: String?, message: String?) {
    val dialog = AwesomeErrorDialog(activity)
    dialog.setTitle(title)
    dialog.setMessage(message)
    dialog.setColoredCircle(R.color.dialogErrorBackgroundColor)
    dialog.setDialogIconAndColor(R.drawable.ic_dialog_error, R.color.white)
    dialog.setCancelable(true)
    dialog.setButtonBackgroundColor(R.color.dialogErrorBackgroundColor)
    dialog.setButtonText(activity.getString(R.string.okay))
    dialog.setErrorButtonClick {

    }
    dialog.show()
}

fun displaySuccessDialog(activity: Activity, title: String?, message: String?) {
    val dialog = AwesomeSuccessDialog(activity)
    dialog.setTitle(title)
    dialog.setMessage(message)
    dialog.setColoredCircle(R.color.dialogSuccessBackgroundColor)
    dialog.setDialogIconAndColor(R.drawable.ic_success, R.color.white)
    dialog.setCancelable(true)
    dialog.setPositiveButtonText(activity.getString(R.string.okay))
    dialog.setPositiveButtonbackgroundColor(R.color.dialogSuccessBackgroundColor)
    dialog.setPositiveButtonTextColor(R.color.white)
    dialog.setPositiveButtonClick {

    }
    dialog.show()
}

fun displayWarningDialog(activity: Activity, title: String?, message: String?) {
    val dialog = AwesomeWarningDialog(activity)
    dialog.setTitle(title)
    dialog.setMessage(message)
    dialog.setColoredCircle(R.color.dialogWarningBackgroundColor)
    dialog.setDialogIconAndColor(R.drawable.ic_dialog_warning, R.color.white)
    dialog.setCancelable(true)
    dialog.setButtonText(activity.getString(R.string.okay))
    dialog.setButtonBackgroundColor(R.color.dialogWarningBackgroundColor)
    dialog.setButtonTextColor(R.color.white)
    dialog.setWarningButtonClick {

    }
    dialog.show()
}

fun getProgressDialog(
    activity: Activity?,
    title: String?,
    message: String?
): AwesomeProgressDialog? {
    val dialog = AwesomeProgressDialog(activity)
    dialog.setTitle(title)
    dialog.setMessage(message)
    dialog.setColoredCircle(R.color.dialogProgressBackgroundColor)
    dialog.setDialogIconAndColor(R.drawable.ic_dialog_error, R.color.white)
    dialog.setCancelable(false)
    return dialog
}


