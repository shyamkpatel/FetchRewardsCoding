package com.example.fetchrewardscoding.data

import com.example.fetchrewardscoding.model.HiringModel
import retrofit2.http.GET




interface HiringService {
    @GET("hiring.json")
    suspend fun getHiring(): List<HiringModel>
}