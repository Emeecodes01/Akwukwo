package com.mobigods.cache.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mobigods.cache.models.ChapterCacheModel
import com.mobigods.cache.utils.BaseTypeConverter

class ChapterListTypeConverter: BaseTypeConverter<List<ChapterCacheModel>, String> {
    private val gson = Gson()

    @TypeConverter
    override fun convertFrom(from: List<ChapterCacheModel>): String {
        return gson.toJson(from)
    }

    @TypeConverter
    override fun convertTo(to: String): List<ChapterCacheModel> {
        val typeToken = object: TypeToken<List<ChapterCacheModel>>(){}.type
        return gson.fromJson(to, typeToken)
    }

}