package com.example.paging3example.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging3example.ProductService
import com.example.paging3example.models.Product
import retrofit2.HttpException
import java.io.IOException

class ProductPagingSource(private val productService: ProductService) :
    PagingSource<Int, Product>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        try {
            val page = params.key ?: 1
            val response = productService.getProducts(pageSize = params.loadSize, pageNumber = page)

            return if (response.isSuccessful) {
                val products = response.body()?.data ?: emptyList()
                //It assumes that the API response always includes the nextPage value,
                // and the paging logic is simple.
                val nextPage = response.body()?.metadata?.nextPage

                /*
                val prevPage = if (page == 1) null else page - 1
                val nextPage = if (products.isEmpty()) null else page + 1
                 */

                LoadResult.Page(
                    data = products,
                    prevKey = null, // Pagination doesn't require previous key
                    nextKey = nextPage
                )
            } else {
                LoadResult.Error(HttpException(response))
            }
        } catch (e: IOException) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}