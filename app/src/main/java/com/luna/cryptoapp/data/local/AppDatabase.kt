package com.luna.cryptoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.luna.cryptoapp.data.local.converters.LinksConverter
import com.luna.cryptoapp.data.local.dao.CoinDao
import com.luna.cryptoapp.data.local.dao.CoinDetailDao
import com.luna.cryptoapp.data.local.entity.CoinDetailEntity
import com.luna.cryptoapp.data.local.entity.CoinEntity
import com.luna.cryptoapp.data.local.converters.LinksExtendedConverter
import com.luna.cryptoapp.data.local.converters.TagConverter
import com.luna.cryptoapp.data.local.converters.TeamMemberConverter
import com.luna.cryptoapp.data.local.converters.WhitePaperConverter

@Database(entities = [CoinEntity::class, CoinDetailEntity::class], version = 1)
@TypeConverters(
    LinksExtendedConverter::class,
    TagConverter::class,
    TeamMemberConverter::class,
    WhitePaperConverter::class,
    LinksConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun coinDao(): CoinDao
    abstract fun coinDetailDao(): CoinDetailDao

}