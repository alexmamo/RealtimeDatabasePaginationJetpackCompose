package ro.alexmamo.realtimedatabasepaginationjetpackcompose.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.data.paging.ProductsPagingSource
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.repository.ProductsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductsRepositoryImpl @Inject constructor(
    private val source: ProductsPagingSource,
    private val config: PagingConfig
) : ProductsRepository {
    override fun getProductsFromRealtimeDatabase() = Pager(
        config = config
    ) {
        source
    }.flow
}