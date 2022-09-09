package com.example.newsfetcher.feature.mainscreen.bookmarks.data.model

import com.example.newsfetcher.feature.mainscreen.domain.ArticleModel


class BookmarksRepositoryImpl(private val bookmarksLocalSource: BookmarksLocalSource):BookmarksRepository {
    override suspend fun create(model: ArticleModel) {

       bookmarksLocalSource.create(model.toEntity())
    }

    override suspend fun read(): List<ArticleModel> {
       return bookmarksLocalSource.read().map { it.toDomain() }
    }

    override suspend fun update(model: ArticleModel) {
        bookmarksLocalSource.update(model.toEntity())
    }

    override suspend fun delete(model: ArticleModel) {
        bookmarksLocalSource.delete(model.toEntity())
    }
}