package com.example.fetchrewardscoding.data

import com.example.fetchrewardscoding.model.HiringModel

class HiringNetworkRepository(private val hiringApiService: HiringService): HiringRepository {

    override suspend fun getHiringData(): List<HiringModel> {
           return hiringApiService.getHiring()
    }
}