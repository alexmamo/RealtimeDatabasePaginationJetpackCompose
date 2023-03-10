package ro.alexmamo.realtimedatabasepaginationjetpackcompose.presentation.product

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.model.Response.Loading
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.repository.ProductRepository
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.repository.ProductResponse
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repo: ProductRepository
): ViewModel() {
    var productResponse by mutableStateOf<ProductResponse>(Loading)
        private set

    fun getProduct(productKey: String) = viewModelScope.launch {
        productResponse = repo.getProductFromRealtimeDatabase(productKey)
    }
}