package com.example.newsfetcher.feature.mainscreen


import com.example.newsfetcher.Base.Event
import com.example.newsfetcher.feature.mainscreen.domain.ArticleModel

data class ViewState(
    val isSearchEnabled: Boolean,
    val articlesShown:List<ArticleModel>,
    val articleList: List<ArticleModel>,

)
sealed class UiEvent:Event {
    data class OnArticleClicked(val index: Int):UiEvent()
    object OnSearchButtonClicked: UiEvent()
    data class OnSearchEdit(val text: String):UiEvent()
}
sealed class DataEvent: Event {
    object LoadArticles:DataEvent()
    data class OnLoadArticlesSucceed(val articles: List<ArticleModel>):DataEvent()
    data class OnLoadArticlesError( val errorText: String): DataEvent()
}