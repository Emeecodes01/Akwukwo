package com.mobigods.core.utils.extensions

import android.content.SharedPreferences

fun SharedPreferences.edit(
    action: SharedPreferences.Editor.() -> Unit){
    edit().apply(action).apply()
}