package com.example.newsfetcher.feature.mainscreen.data.model

import com.example.newsfetcher.feature.mainscreen.domain.ArticleModel

class ArticlesRepositoryImpl(private val source: ArticlesRemoteSource):ArticlesRepository {

    override suspend fun getArticles():List<ArticleModel> {

        return source.getArticles().articleList.asSequence()
            . map { it.toDomain() }
            . sortedByDescending {it.publishedAt}
            .toList()



    }
}