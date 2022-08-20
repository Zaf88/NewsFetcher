package com.example.newsfetcher.feature.mainscreen.di


import com.example.newsfetcher.feature.mainscreen.MainScreenViewModel
import com.example.newsfetcher.feature.mainscreen.NewsApi
import com.example.newsfetcher.feature.mainscreen.data.model.ArticlesRemoteSource
import com.example.newsfetcher.feature.mainscreen.data.model.ArticlesRepository
import com.example.newsfetcher.feature.mainscreen.data.model.ArticlesRepositoryImpl
import com.example.newsfetcher.feature.mainscreen.domain.ArticlesInteractor
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module
import retrofit2.Retrofit

val mainScreenModule = module {
    single<NewsApi> {
        get<Retrofit>().create(NewsApi::class.java)
    }
    single<ArticlesRemoteSource> {
        ArticlesRemoteSource(api = get())
    }
    single<ArticlesRepository> {
        ArticlesRepositoryImpl(source = get())
    }
    single<ArticlesInteractor> {
        ArticlesInteractor(repository = get())
    }
    viewModel {
        MainScreenViewModel(interactor = get(), bookmarksInteractor = get())
    }
}