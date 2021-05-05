package com.abeltarazona.presentation.utils

/**
 * Created by AbelTarazona on 5/05/2021
 */
interface UiModel

open class UiAwareModel : UiModel {
    var isRedelivered: Boolean = false
}