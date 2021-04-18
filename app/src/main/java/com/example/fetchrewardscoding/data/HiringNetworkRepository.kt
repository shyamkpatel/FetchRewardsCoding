package com.example.fetchrewardscoding.data

import com.example.fetchrewardscoding.model.HiringModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HiringNetworkRepository: HiringRepository {

    val baseUrl = "https://fetch-hiring.s3.amazonaws.com/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val hiringApiService: HiringService by lazy { retrofit.create(HiringService::class.java) }

    override suspend fun getHiringData(): List<HiringModel> {
           return hiringApiService.getHiring()
    }
}