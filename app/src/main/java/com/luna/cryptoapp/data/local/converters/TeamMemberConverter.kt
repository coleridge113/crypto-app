package com.luna.cryptoapp.data.local.converters

import androidx.room.TypeConverter
import com.luna.cryptoapp.data.remote.dto.TeamMember
import kotlinx.serialization.json.Json

class TeamMemberConverter {
    @TypeConverter
    fun fromTeamMemberList(value: List<TeamMember>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toTeamMemberList(value: String): List<TeamMember> {
        return Json.decodeFromString(value)
    }
}