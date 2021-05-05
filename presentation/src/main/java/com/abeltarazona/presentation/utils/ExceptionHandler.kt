package com.abeltarazona.presentation.utils

import androidx.annotation.StringRes
import com.abeltarazona.presentation.R
import java.net.UnknownHostException

/**
 * Created by AbelTarazona on 5/05/2021
 */
internal object ExceptionHandler {

    @StringRes
    fun parse(t: Throwable): Int {
        return when (t) {
            is UnknownHostException -> R.string.error_check_internet_connection
            else -> R.string.error_oops_error_occured
        }
    }

}