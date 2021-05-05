package com.abeltarazona.challenge.ui.custom

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.abeltarazona.challenge.R

/**
 * Created by AbelTarazona on 4/05/2021
 */
class TextFieldView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    init {
        inflate(context, R.layout.text_field_view, this)
        val title: TextView = findViewById(R.id.tvTitle)
        val editText: EditText = findViewById(R.id.etValue)
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.TextFieldView)
        title.text = attributes.getString(R.styleable.TextFieldView_title)
        editText.hint = attributes.getString(R.styleable.TextFieldView_title)
        val isPass: Boolean = attributes.getBoolean(R.styleable.TextFieldView_isPassword, false)
        editText.inputType = if (isPass) InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD else InputType.TYPE_CLASS_TEXT
        attributes.recycle()
    }

    fun getContent(): String {
        return findViewById<EditText>(R.id.etValue).text.toString()
    }
}