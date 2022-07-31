package com.example.newsfetcher.feature.mainscreen.data.model

import com.example.newsfetcher.feature.mainscreen.domain.ArticleModel

fun ArticleRemoteModel.toDomain() = ArticleModel(
    author = author ?:"",
    tittle = tittle ?:"",
    description = description ?:"",
    url = url
)