package ro.alexmamo.realtimedatabasepaginationjetpackcompose.data.repository

import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.tasks.await
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.PRODUCTS
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.model.Product
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.model.Response.Failure
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.model.Response.Success
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.repository.ProductRepository
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.repository.ProductResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepositoryImpl @Inject constructor(
    private val db: DatabaseReference
): ProductRepository {
    override suspend fun getProductFromRealtimeDatabase(productKey: String): ProductResponse = try {
        val productKeyRef = db.child(PRODUCTS).child(productKey)
        val product = productKeyRef.get().await().getValue(Product::class.java)
        Success(product)
    } catch (e: Exception) {
        Failure(e)
    }
}