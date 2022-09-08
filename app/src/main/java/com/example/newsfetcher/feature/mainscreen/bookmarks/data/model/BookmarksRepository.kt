package com.example.newsfetcher.feature.mainscreen.bookmarks.data.model

import com.example.newsfetcher.feature.mainscreen.domain.ArticleModel

interface BookmarksRepository {

    suspend fun create(model: ArticleModel)

    suspend fun read(): List<ArticleModel>

    suspend fun update(model: ArticleModel)

    suspend fun delete(model: ArticleModel)
}



