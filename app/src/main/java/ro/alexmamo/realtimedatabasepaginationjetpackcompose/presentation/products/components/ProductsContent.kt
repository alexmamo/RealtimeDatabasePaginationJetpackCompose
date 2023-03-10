package ro.alexmamo.realtimedatabasepaginationjetpackcompose.presentation.products.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.components.ProgressBar
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Utils.Companion.printErrorState
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.presentation.products.ProductsViewModel

@Composable
@ExperimentalPagingApi
fun ProductsContent(
    viewModel: ProductsViewModel = hiltViewModel(),
    padding: PaddingValues,
    navigateToProductScreen: (productKey: String) -> Unit
) {
    val pagingProducts = viewModel.products.collectAsLazyPagingItems()
    val refresh = pagingProducts.loadState.refresh
    val append = pagingProducts.loadState.append

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        items(
            items = pagingProducts
        ) { product ->
            product?.let {
                ProductCard(
                    product = product,
                    onProductClick = navigateToProductScreen
                )
            }
        }
    }

    pagingProducts.loadState.apply {
        when {
            refresh is LoadState.Loading -> ProgressBar()
            refresh is LoadState.Error -> printErrorState(refresh)
            append is LoadState.Loading -> ProgressBar()
            append is LoadState.Error -> printErrorState(append)
        }
    }
}