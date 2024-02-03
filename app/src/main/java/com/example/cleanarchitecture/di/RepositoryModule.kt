package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.store.data.repository.ProductRepositoryImplementation
import com.example.cleanarchitecture.store.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProductsRepository(impl : ProductRepositoryImplementation): ProductRepository
}