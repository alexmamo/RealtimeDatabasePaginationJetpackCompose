package ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.model

data class Product (
    var key: String? = null,
    var name: String? = null,
    var imageUrl: String? = null,
    var details: String? = null,
    var price: Int? = null,
    var stock: Int? = null,
    var height: Double? = null,
    var width: Double? = null,
    var depth: Double? = null,
    var weight: Double? = null,
    var qrCode: String? = null
)