package com.luna.cryptoapp.data.local.converters

import androidx.room.TypeConverter
import com.luna.cryptoapp.data.remote.dto.LinksExtended
import kotlinx.serialization.json.Json

class LinksExtendedConverter {
    @TypeConverter
    fun fromLinksExtendedList(value: List<LinksExtended>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toLinksExtendedList(value: String): List<LinksExtended> {
        return Json.decodeFromString(value)
    }
}