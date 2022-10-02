package com.qq.runing.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Database(entities = [Run::class], version = 1)

@TypeConverters(Converter::class)
abstract class RunningDatabase : RoomDatabase() {
    abstract fun getRunDao(): RunDAO
}