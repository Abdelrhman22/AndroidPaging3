package com.example.paging3example

import com.example.paging3example.models.Product
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paging3example.paging.ProductPagingSource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart


@HiltViewModel
class ProductViewModel @Inject constructor(private val service: ProductService) : ViewModel() {

    fun getProducts(): Flow<PagingData<Product>> {
        // you will find it multiply page size * 3 -> pageSize * DEFAULT_INITIAL_PAGE_MULTIPLIER
        // so we need to send in constructor
        val pager = Pager(PagingConfig(pageSize = 10, initialLoadSize = 10)) {
            ProductPagingSource(productService = service)
        }

        return pager.flow
            .cachedIn(viewModelScope)
            .onStart { }
            .catch { }
            .onCompletion { }
    }

    val flow = Pager(PagingConfig(pageSize = 10, initialLoadSize = 10)) {
        ProductPagingSource(productService = service)
    }.flow
        .cachedIn(viewModelScope)
        .onStart { }
        .catch { }
        .onCompletion { }


}