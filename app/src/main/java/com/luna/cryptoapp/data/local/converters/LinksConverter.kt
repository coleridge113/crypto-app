package com.luna.cryptoapp.data.local.converters

import androidx.room.TypeConverter
import com.luna.cryptoapp.data.remote.dto.Links
import kotlinx.serialization.json.Json

class LinksConverter {
    @TypeConverter
    fun fromLinks(value: Links): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toLinks(value: String): Links {
        return Json.decodeFromString(value)
    }
}