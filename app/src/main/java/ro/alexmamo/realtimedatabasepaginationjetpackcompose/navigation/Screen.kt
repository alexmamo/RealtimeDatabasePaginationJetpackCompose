package ro.alexmamo.realtimedatabasepaginationjetpackcompose.navigation

import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.PRODUCTS_SCREEN
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.PRODUCT_SCREEN

sealed class Screen(val route: String) {
    object ProductsScreen: Screen(PRODUCTS_SCREEN)
    object ProductScreen: Screen(PRODUCT_SCREEN)
}