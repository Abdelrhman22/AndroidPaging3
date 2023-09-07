package com.example.paging3example.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Category(

    @SerializedName("_id") val Id: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("slug") val slug: String? = null

)