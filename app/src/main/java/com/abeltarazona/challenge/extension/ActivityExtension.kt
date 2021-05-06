package com.abeltarazona.challenge.extension

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.abeltarazona.challenge.R
import com.google.android.material.snackbar.Snackbar

/**
 * Created by AbelTarazona on 5/05/2021
 */
internal fun Activity.showSnackBar(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).apply {
        anchorView = view.findViewById(android.R.id.content)
        show()
    }
}

internal fun Fragment.showSnackBar(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).apply {
        anchorView = view.findViewById(android.R.id.content)
        show()
    }
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)