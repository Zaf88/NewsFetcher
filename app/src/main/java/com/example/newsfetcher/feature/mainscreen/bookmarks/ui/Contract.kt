package com.example.newsfetcher.feature.mainscreen.bookmarks.ui

import com.example.newsfetcher.feature.mainscreen.domain.ArticleModel

data class ViewState(
    val bookmarksArticle:List<ArticleModel>
)
sealed class UiEvent()
sealed class DataEvent()