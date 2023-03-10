package ro.alexmamo.realtimedatabasepaginationjetpackcompose.presentation.products.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.PRODUCTS_SCREEN

@Composable
fun ProductsTopBar() {
    TopAppBar (
        title = {
            Text(
                text = PRODUCTS_SCREEN
            )
        }
    )
}