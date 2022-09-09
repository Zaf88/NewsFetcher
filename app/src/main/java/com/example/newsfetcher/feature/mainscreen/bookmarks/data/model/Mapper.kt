package com.example.newsfetcher.feature.mainscreen.bookmarks.data.model

import com.example.newsfetcher.feature.mainscreen.domain.ArticleModel

fun BookmarkEntity.toDomain()=ArticleModel(
    title = title,
    description = description,
    url = url,
    author = author,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content
)
fun ArticleModel.toEntity()=  BookmarkEntity (


                            title = title,
                            description = description ?: "",
                            url = url ?: "",
                            author = author?: "",
                            urlToImage = urlToImage ?: "",
                            publishedAt = publishedAt ?: "",
                            content = content ?: "",
                        )

