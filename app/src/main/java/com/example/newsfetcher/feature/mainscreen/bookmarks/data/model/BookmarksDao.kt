package com.example.newsfetcher.feature.mainscreen.bookmarks.data.model

import androidx.room.*
import com.example.newsfetcher.feature.mainscreen.bookmarks.di.BOOKMARKS_TABLE

@Dao
 interface BookmarksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create (entity: com.example.newsfetcher.feature.mainscreen.bookmarks.data.model.BookmarkEntity)

    @Query ("SELECT * FROM $BOOKMARKS_TABLE")
    suspend fun read(): List<BookmarkEntity>

    @Update
    suspend fun update (entity: com.example.newsfetcher.feature.mainscreen.bookmarks.data.model.BookmarkEntity)

    @Delete
    suspend fun delete (entity: com.example.newsfetcher.feature.mainscreen.bookmarks.data.model.BookmarkEntity)
}