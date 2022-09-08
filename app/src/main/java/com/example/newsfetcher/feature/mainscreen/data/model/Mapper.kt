package com.example.newsfetcher.feature.mainscreen.data.model

import com.example.newsfetcher.feature.mainscreen.domain.ArticleModel

fun ArticleRemoteModel.toDomain() = ArticleModel(

    author = author ?:"",
    title = title ?:"",
    description = description ?:"",
    url = url ?:"",
    urlToImage = urlToImage?: "",
    publishedAt = publishedAt ?:"",
    content = content ?:""
)