package com.example.paging3example.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Metadata(

    @SerializedName("currentPage") val currentPage: Int? = null,
    @SerializedName("totalProducts") val totalProducts: Int? = null,
    @SerializedName("nextPage") val nextPage: Int? = null,
    @SerializedName("prevPage") val prevPage: Int? = null,
    @SerializedName("totalPages") val totalPages: Int? = null

)