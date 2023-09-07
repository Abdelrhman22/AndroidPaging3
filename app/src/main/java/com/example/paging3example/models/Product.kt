package com.example.paging3example.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Product(

    @SerializedName("_id") val Id: String? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("price") val price: Int? = null,
    @SerializedName("category") val category: Category? = Category(),
    @SerializedName("description") val description: String? = null,
    @SerializedName("createdBy") val createdBy: CreatedBy? = CreatedBy(),
    @SerializedName("createdAt") val createdAt: String? = null,
    @SerializedName("updatedAt") val updatedAt: String? = null,
    @SerializedName("slug") val slug: String? = null,
    @SerializedName("image") val image: String? = null

)