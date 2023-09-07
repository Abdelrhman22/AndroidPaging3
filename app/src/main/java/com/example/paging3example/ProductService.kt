package com.example.paging3example

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {

    @GET("/products")
    suspend fun getProducts(@Query("limit") pageSize: Int, @Query("page") pageNumber: Int):
            Response<ProductResponse>
}