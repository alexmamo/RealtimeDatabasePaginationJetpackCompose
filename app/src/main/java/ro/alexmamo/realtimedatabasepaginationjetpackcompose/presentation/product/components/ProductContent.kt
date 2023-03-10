package ro.alexmamo.realtimedatabasepaginationjetpackcompose.presentation.product.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.CM
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.DEPTH
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.DETAILS
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.HEIGHT
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.IMAGE_URL
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.KG
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.NAME
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.PRICE
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.STOCK
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.WEIGHT
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.WIDTH
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.presentation.product.ProductViewModel

@Composable
fun ProductContent(
    padding: PaddingValues,
    viewModel: ProductViewModel = hiltViewModel(),
    productKey: String,
) {
    LaunchedEffect(Unit) {
        viewModel.getProduct(productKey)
    }

    Product(
        productContent = { product ->
            Column(
                modifier = Modifier.fillMaxSize().padding(
                    top = 8.dp,
                    start = 8.dp
                ).padding(padding)
            ) {
                product.apply {
                    name?.let {
                        Text(
                            text = "${NAME}: $name",
                            fontSize = 24.sp
                        )
                    }
                    imageUrl?.let {
                        Text(
                            text = "${IMAGE_URL}: $imageUrl",
                            fontSize = 24.sp
                        )
                    }
                    details?.let {
                        Text(
                            text = "${DETAILS}: $details",
                            fontSize = 24.sp
                        )
                    }
                    price?.let {
                        Text(
                            text = "${PRICE}: $$price",
                            fontSize = 24.sp
                        )
                    }
                    stock?.let {
                        Text(
                            text = "${STOCK}: $stock",
                            fontSize = 24.sp
                        )
                    }
                    height?.let {
                        Text(
                            text = "${HEIGHT}: $height $CM",
                            fontSize = 24.sp
                        )
                    }
                    width?.let {
                        Text(
                            text = "${WIDTH}: $width $CM",
                            fontSize = 24.sp
                        )
                    }
                    depth?.let {
                        Text(
                            text = "${DEPTH}: $depth $CM",
                            fontSize = 24.sp
                        )
                    }
                    weight?.let {
                        Text(
                            text = "${WEIGHT}: $weight $KG",
                            fontSize = 24.sp
                        )
                    }
                }
            }
        }
    )
}