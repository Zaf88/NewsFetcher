package com.example.newsfetcher.feature.mainscreen.data.model

import com.example.newsfetcher.feature.mainscreen.domain.ArticleModel

fun ArticleRemoteModel.toDomain() = ArticleModel(
    title = title,
    author = author ?:"",
    description = description ?:"",
    url = url
)