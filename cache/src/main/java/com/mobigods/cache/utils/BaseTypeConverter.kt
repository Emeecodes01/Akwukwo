package com.mobigods.cache.utils

import androidx.room.TypeConverter

interface BaseTypeConverter<FROM, TO> {
    fun convertFrom(from: FROM): TO
    fun convertTo(to: TO): FROM

}