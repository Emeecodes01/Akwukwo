package com.mobigods.core.utils.extensions

import android.view.View

fun View.click(action: () -> Unit) {
    setOnClickListener {
        action.invoke()
    }
}