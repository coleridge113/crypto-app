package com.luna.cryptoapp.data.local.converters

import androidx.room.TypeConverter
import com.luna.cryptoapp.data.remote.dto.Whitepaper
import kotlinx.serialization.json.Json

class WhitePaperConverter {
    @TypeConverter
    fun fromWhitepaper(value: Whitepaper): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toWhitepaper(value: String): Whitepaper {
        return Json.decodeFromString(value)
    }
}