package com.example.newsfetcher

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsfetcher.feature.mainscreen.bookmarks.data.model.BookmarkEntity
import com.example.newsfetcher.feature.mainscreen.bookmarks.data.model.BookmarksDao

@Database(entities = [BookmarkEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bookmarksDao(): BookmarksDao

}
