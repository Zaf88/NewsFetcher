package com.example.newsfetcher.feature.mainscreen.domain

import com.google.gson.annotations.SerializedName

data class ArticleModel(
    val author: String,
    val tittle: String,
    val description: String,
    val url: String
)
