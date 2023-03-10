package ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.repository

import ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.model.Product
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.model.Response

typealias ProductResponse = Response<Product>

interface ProductRepository {
    suspend fun getProductFromRealtimeDatabase(productKey: String): ProductResponse
}