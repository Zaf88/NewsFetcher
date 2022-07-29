package com.example.newsfetcher.di

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://newsapi.org/"
const val API_KEY ="8d69d5f451884a9883e0a2c223785717"
val appModule = module {

    single<OkHttpClient> {
        OkHttpClient
            .Builder()
            .addInterceptor(
                HttpLoggingInterceptor{message->
                    Log.d("OkHttp",message)
                }.apply {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                }
            )
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }
}