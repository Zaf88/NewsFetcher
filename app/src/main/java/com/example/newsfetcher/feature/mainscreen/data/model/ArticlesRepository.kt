package com.example.newsfetcher.feature.mainscreen.data.model

import com.example.newsfetcher.feature.mainscreen.domain.ArticleModel


interface ArticlesRepository {

suspend fun getArticles():List<ArticleModel>
}