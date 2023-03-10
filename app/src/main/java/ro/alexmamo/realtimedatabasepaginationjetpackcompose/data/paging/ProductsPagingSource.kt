package ro.alexmamo.realtimedatabasepaginationjetpackcompose.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.tasks.await
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.PAGE_SIZE
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.PRODUCT_NAMES
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.model.Product

class ProductsPagingSource(
    private val db: DatabaseReference
) : PagingSource<DataSnapshot, Product>() {
    override fun getRefreshKey(state: PagingState<DataSnapshot, Product>): DataSnapshot? = null

    override suspend fun load(params: LoadParams<DataSnapshot>) = try {
        val queryProductNames = db.child(PRODUCT_NAMES).orderByKey().limitToFirst(PAGE_SIZE)
        val currentPage = params.key ?: queryProductNames.get().await()
        val lastVisibleProductKey = currentPage.children.last().key
        val nextPage = queryProductNames.startAfter(lastVisibleProductKey).get().await()
        val products = currentPage.children.map { snapshot ->
            snapshot.toProduct()
        }
        LoadResult.Page(
            data = products,
            prevKey = null,
            nextKey = nextPage
        )
    } catch (e: Exception) {
        LoadResult.Error(e)
    }
}

fun DataSnapshot.toProduct() = Product(
    key = key,
    name = getValue(String::class.java)
)