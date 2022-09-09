package com.example.newsfetcher.feature.mainscreen.bookmarks.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.newsfetcher.Base.BaseViewModel
import com.example.newsfetcher.Base.Event
import com.example.newsfetcher.feature.mainscreen.bookmarks.domain.BookmarksInteractor
import kotlinx.coroutines.launch

class BookmarksScreenViewModel(private val interactor: BookmarksInteractor) :
    BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadBookmarks)
    }

    override fun InitialViewState(): ViewState = ViewState(bookmarksArticle = emptyList())

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.LoadBookmarks -> {
                viewModelScope.launch {
                    interactor.read().fold(
                        onError = {},
                        onSuccess = {
                            processDataEvent(DataEvent.OnSuccessBookmarksLoaded(it))
                        }
                    )
                }
                return null
            }

            is DataEvent.OnSuccessBookmarksLoaded -> {
                Log.d("Room", "articleBookmark=${event.bookmarksArticle}")
                return previousState.copy(bookmarksArticle = event.bookmarksArticle)
            }


            //при нажатии на кнопку удаляется статья в базе данных
            is UiEvent.OnArticleClicked -> {
                viewModelScope.launch {
                    interactor.delete(previousState.bookmarksArticle[event.index])

                }
                return null
            }


            else -> return null
        }
    }
}

