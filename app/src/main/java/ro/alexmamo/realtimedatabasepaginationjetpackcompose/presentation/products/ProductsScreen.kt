package ro.alexmamo.realtimedatabasepaginationjetpackcompose.presentation.products

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.paging.ExperimentalPagingApi
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.presentation.products.components.ProductsContent
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.presentation.products.components.ProductsTopBar

@Composable
@ExperimentalPagingApi
fun ProductsScreen(
    navigateToProductScreen: (productKey: String) -> Unit
) {
    Scaffold(
        topBar = {
            ProductsTopBar()
        },
        content = { padding ->
            ProductsContent(
                padding = padding,
                navigateToProductScreen = navigateToProductScreen
            )

        }
    )
}