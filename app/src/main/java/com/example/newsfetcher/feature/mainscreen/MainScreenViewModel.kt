package com.example.newsfetcher.feature.mainscreen

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.newsfetcher.Base.BaseViewModel
import com.example.newsfetcher.Base.Event
import com.example.newsfetcher.feature.mainscreen.bookmarks.domain.BookmarksInteractor
import com.example.newsfetcher.feature.mainscreen.domain.ArticlesInteractor
import kotlinx.coroutines.launch


class MainScreenViewModel(
    private val interactor: ArticlesInteractor,
    private val bookmarksInteractor: BookmarksInteractor
) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadArticles)
    }

    override fun InitialViewState() = ViewState(
        articleList = emptyList(),
        articlesShown = emptyList(),
        isSearchEnabled = false,
        editText = "",
        favoriteArticlesChoice = true,

        )


    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.LoadArticles -> {
                viewModelScope.launch {
                    interactor.getArticles().fold(
                        onError = {
                            Log.e("ERROR", it.localizedMessage)
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnLoadArticlesSucceed(it))
                        }
                    )
                }

                return null
            }

            is DataEvent.OnLoadArticlesSucceed -> {
                return previousState.copy(
                    articleList = event.articles,
                    articlesShown = event.articles
                )

            }


            is UiEvent.OnArticleClicked -> {
                previousState.articleList[event.index].favoriteArticlesChoice = true

                viewModelScope.launch {
                    bookmarksInteractor.create(previousState.articlesShown[event.index])
                }
                return null
            }
            is UiEvent.OnSearchButtonClicked -> {
                return previousState.copy(
                    articlesShown = if (previousState.isSearchEnabled)
                        previousState.articleList else previousState.articlesShown,
                    isSearchEnabled = !previousState.isSearchEnabled
                )
            }

            is UiEvent.OnSearchEdit -> {
                return previousState.copy(articlesShown = previousState.articleList.filter {
                    it.title.contains(
                        event.text
                    )
                }, isSearchEnabled = previousState.isSearchEnabled)
            }

            else -> return null
        }
        return null
    }
}