package ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.model.Product

interface ProductsRepository {
    fun getProductsFromRealtimeDatabase(): Flow<PagingData<Product>>
}