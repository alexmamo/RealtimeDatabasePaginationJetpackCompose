package ro.alexmamo.realtimedatabasepaginationjetpackcompose.presentation.product

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.presentation.product.components.ProductContent
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.presentation.product.components.ProductTopBar

@Composable
fun ProductScreen(
    productKey: String,
    navigateBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            ProductTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            ProductContent(
                padding = padding,
                productKey = productKey
            )
        }
    )
}