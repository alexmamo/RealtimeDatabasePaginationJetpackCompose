package ro.alexmamo.realtimedatabasepaginationjetpackcompose.presentation.product.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.components.ProgressBar
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Utils.Companion.printError
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.model.Product
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.model.Response.*
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.presentation.product.ProductViewModel

@Composable
fun Product(
    viewModel: ProductViewModel = hiltViewModel(),
    productContent: @Composable (product: Product) -> Unit
) {
    when(val productResponse = viewModel.productResponse) {
        is Loading -> ProgressBar()
        is Success -> productResponse.data?.let { product ->
            productContent(product)
        }
        is Failure -> printError(productResponse.e)
    }
}