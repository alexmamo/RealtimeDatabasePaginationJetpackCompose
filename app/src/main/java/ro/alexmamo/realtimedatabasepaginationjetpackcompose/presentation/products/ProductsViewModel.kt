package ro.alexmamo.realtimedatabasepaginationjetpackcompose.presentation.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.repository.ProductsRepository
import javax.inject.Inject

@HiltViewModel
@ExperimentalPagingApi
class ProductsViewModel @Inject constructor(
    repo: ProductsRepository
): ViewModel() {
    val products = repo.getProductsFromRealtimeDatabase().cachedIn(viewModelScope)
}