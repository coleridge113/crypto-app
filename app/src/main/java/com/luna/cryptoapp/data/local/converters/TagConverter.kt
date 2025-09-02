package com.luna.cryptoapp.data.local.converters

import androidx.room.TypeConverter
import com.luna.cryptoapp.data.remote.dto.Tag
import kotlinx.serialization.json.Json

class TagConverter {
    @TypeConverter
    fun fromTagList(value: List<Tag>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toTagList(value: String): List<Tag> {
        return Json.decodeFromString(value)
    }
}