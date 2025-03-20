package com.appconcept.test.database

import androidx.room.Database
import androidx.room.RoomDatabase



@Database(
    entities = [
        Album::class
    ],
    version = 2,
    exportSchema = false
)



abstract class AppDatabase : RoomDatabase() {
    abstract fun albumDao(): AlbumDao


}
