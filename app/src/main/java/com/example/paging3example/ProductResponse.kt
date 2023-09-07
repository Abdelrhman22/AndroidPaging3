package com.example.paging3example

import com.example.paging3example.models.Product
import com.example.paging3example.models.Metadata
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(

    @SerializedName("metadata") val metadata: Metadata? = Metadata(),
    @SerializedName("data") val data: List<Product> = arrayListOf(),
    @SerializedName("status") val status: Int? = null,
    @SerializedName("message") val message: String? = null

)