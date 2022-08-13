package com.example.newsfetcher.feature.mainscreen.bookmarks.domain

import com.example.newsfetcher.feature.mainscreen.bookmarks.data.model.BookmarksRepository
import com.example.newsfetcher.feature.mainscreen.bookmarks.data.model.toDomain
import com.example.newsfetcher.feature.mainscreen.bookmarks.data.model.toEntity
import com.example.newsfetcher.feature.mainscreen.domain.ArticleModel

class BookmarksInteractor(private val bookmarksRepository: BookmarksRepository) {
    suspend fun create(model: ArticleModel) {
        bookmarksRepository.create(model)
    }

    suspend fun read(): List<ArticleModel> {
        return bookmarksRepository.read()
    }

    suspend fun update(model: ArticleModel) {
        bookmarksRepository.update(model)
    }

    suspend fun delete(model: ArticleModel) {
        bookmarksRepository.delete(model)
    }
}

