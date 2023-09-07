package com.example.paging3example.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CreatedBy(

    @SerializedName("role") val role: String? = null,
    @SerializedName("_id") val Id: String? = null,
    @SerializedName("name") val name: String? = null

)