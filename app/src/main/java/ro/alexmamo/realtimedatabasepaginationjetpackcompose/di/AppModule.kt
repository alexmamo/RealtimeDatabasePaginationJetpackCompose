package ro.alexmamo.realtimedatabasepaginationjetpackcompose.di

import androidx.paging.PagingConfig
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.PAGE_SIZE
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.data.repository.ProductRepositoryImpl
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.data.paging.ProductsPagingSource
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.data.repository.ProductsRepositoryImpl
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.repository.ProductRepository
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.domain.repository.ProductsRepository

@Module
@InstallIn(ViewModelComponent::class)
class AppModule {
    @Provides
    fun provideRootRef() = Firebase.database.reference

    @Provides
    fun provideProductsPagingSource(
        db: DatabaseReference
    ) = ProductsPagingSource(
        db = db
    )

    @Provides
    fun providePagingConfig() = PagingConfig(
        pageSize = PAGE_SIZE
    )

    @Provides
    fun provideProductsRepository(
        source: ProductsPagingSource,
        config: PagingConfig
    ): ProductsRepository = ProductsRepositoryImpl(
        source = source,
        config = config
    )

    @Provides
    fun provideProductRepository(
        db: DatabaseReference
    ): ProductRepository = ProductRepositoryImpl(
        db = db
    )
}