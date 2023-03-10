package ro.alexmamo.realtimedatabasepaginationjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.paging.ExperimentalPagingApi
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.NO_VALUE
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.PRODUCT_KEY
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.navigation.Screen.ProductScreen
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.navigation.Screen.ProductsScreen
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.presentation.products.ProductsScreen
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.presentation.product.ProductScreen

@Composable
@ExperimentalPagingApi
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ProductsScreen.route
    ) {
        composable(
            route = ProductsScreen.route
        ) {
            ProductsScreen(
                navigateToProductScreen = { productKey ->
                    navController.navigate("${ProductScreen.route}/${productKey}")
                }
            )
        }
        composable(
            route = "${ProductScreen.route}/{$PRODUCT_KEY}",
            arguments = listOf(
                navArgument(PRODUCT_KEY) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val productKey = backStackEntry.arguments?.getString(PRODUCT_KEY) ?: NO_VALUE
            ProductScreen(
                productKey = productKey,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}