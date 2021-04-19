package com.example.fetchrewardscoding

import com.example.fetchrewardscoding.data.HiringService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceLocator {
    private val baseUrl = "https://fetch-hiring.s3.amazonaws.com/"

    private val retrofitClient by lazy {
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

    val hiringApiService: HiringService by lazy { retrofitClient.create(HiringService::class.java) }

}