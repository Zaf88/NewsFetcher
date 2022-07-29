package com.example.newsfetcher.feature.mainscreen.di


import com.example.newsfetcher.feature.mainscreen.NewsApi
import org.koin.dsl.module
import retrofit2.Retrofit

val MainScreenModule = module {
    single {
        get<Retrofit>().create(NewsApi::class.java)
    }
}