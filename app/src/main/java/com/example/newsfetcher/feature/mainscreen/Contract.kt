package com.example.newsfetcher.feature.mainscreen


import com.example.newsfetcher.Base.Event
import com.example.newsfetcher.feature.mainscreen.domain.ArticleModel

data class ViewState(
    val articles:List<ArticleModel>
)
sealed class DataEvent: Event {
    object LoadArticles:DataEvent()
    data class OnLoadArticlesSucceed(val articles: List<ArticleModel>):DataEvent()
}