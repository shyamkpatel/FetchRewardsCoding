package com.example.fetchrewardscoding.data

import com.example.fetchrewardscoding.model.HiringModel

interface HiringRepository {
    suspend fun getHiringData(): List<HiringModel>
}