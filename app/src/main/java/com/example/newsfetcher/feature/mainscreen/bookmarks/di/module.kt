package com.example.newsfetcher.feature.mainscreen.bookmarks.di

import com.example.newsfetcher.feature.mainscreen.bookmarks.data.model.BookmarksLocalSource
import com.example.newsfetcher.feature.mainscreen.bookmarks.data.model.BookmarksRepository
import com.example.newsfetcher.feature.mainscreen.bookmarks.data.model.BookmarksRepositoryImpl
import com.example.newsfetcher.feature.mainscreen.bookmarks.domain.BookmarksInteractor
import com.example.newsfetcher.feature.mainscreen.bookmarks.ui.BookmarksScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

const val BOOKMARKS_TABLE = "BOOKMARKS_TABLE"

val bookmarksModule = module {

    single {
        BookmarksLocalSource(bookmarksDao = get())
    }
    single<BookmarksRepository> {
        BookmarksRepositoryImpl(bookmarksLocalSource = get())
    }
    single {
        BookmarksInteractor(bookmarksRepository = get())
    }
    viewModel {
    BookmarksScreenViewModel(interactor = get())
    }
}