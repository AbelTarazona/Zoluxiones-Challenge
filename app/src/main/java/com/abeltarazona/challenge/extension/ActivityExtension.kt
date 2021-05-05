package com.abeltarazona.challenge.extension

import android.app.Activity
import android.view.View
import androidx.fragment.app.Fragment
import com.abeltarazona.challenge.R
import com.google.android.material.snackbar.Snackbar

/**
 * Created by AbelTarazona on 5/05/2021
 */
internal fun Activity.showSnackBar(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).apply {
        anchorView = view.rootView.findViewById(R.id.navigationHostFragment)
        show()
    }
}

internal fun Fragment.showSnackBar(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).apply {
        anchorView = view.rootView.findViewById(R.id.navigationHostFragment)
        show()
    }
}