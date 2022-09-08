package com.example.newsfetcher.feature.mainscreen.data.model

import com.example.newsfetcher.feature.mainscreen.NewsApi

class ArticlesRemoteSource(private val api:NewsApi) {

suspend fun getArticles(): ArticlesRemoteModel {
    return api.getArticles()
}

}