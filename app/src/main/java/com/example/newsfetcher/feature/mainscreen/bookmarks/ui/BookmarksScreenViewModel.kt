package com.example.newsfetcher.feature.mainscreen.bookmarks.ui

import com.example.newsfetcher.Base.BaseViewModel
import com.example.newsfetcher.Base.Event
import com.example.newsfetcher.feature.mainscreen.bookmarks.domain.BookmarksInteractor

class BookmarksScreenViewModel(private val interactor: BookmarksInteractor):BaseViewModel<ViewState>() {
    override fun InitialViewState(): ViewState = ViewState(bookmarksArticle = emptyList())

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        return null
    }
}


