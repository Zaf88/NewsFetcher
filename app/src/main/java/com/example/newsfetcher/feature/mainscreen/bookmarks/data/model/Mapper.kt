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
fun ArticleModel.toEntity()= description?.let {
    if (author != null) {
        if (urlToImage != null) {
            if (publishedAt != null) {
                if (content != null) {
                    if (url != null) {
                        BookmarkEntity(
                            title = title,
                            description = it,
                            url = url,
                            author = author,
                            urlToImage = urlToImage,
                            publishedAt = publishedAt,
                            content = content
                        )
                    }
                }
            }
        }
    }
}