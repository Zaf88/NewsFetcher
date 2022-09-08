package com.example.newsfetcher.feature.mainscreen.articleInfoFragment.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val articleInfoModule =module {


    viewModel {
        ArticleInfoViewModel()
    }
}