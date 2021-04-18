package com.example.fetchrewardscoding.model

import com.google.gson.annotations.SerializedName

data class HiringModel (
    @SerializedName("id")
    val id: Int,
    @SerializedName("listId")
    val listId: Int,
    @SerializedName("name")
    val name: String? )